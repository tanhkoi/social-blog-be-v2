package com.javaproject.socialblog.springboot.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.javaproject.socialblog.springboot.model.entities.User;
import com.javaproject.socialblog.springboot.model.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {

    private final JwtProperties jwtProperties;

    public String generateToken(User user) {

        final String username = user.getUsername();
        final UserRole userRole = user.getUserRole();
        final String userId = user.getId();
        final boolean enable = user.isEnabled();

        //@formatter:off
		return JWT.create()
				.withSubject(username)
                .withClaim("userId", userId)
                .withClaim("role", userRole.name())
                .withClaim("enable", enable)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMinute() * 60 * 1000))
				.sign(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes()));
		//@formatter:on
    }

    public String getUsernameFromToken(String token) {

        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getSubject();
    }

    public String getUserIdFromToken(String token) {
        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getClaim("userId").asString();
    }

    public String getUserRoleFromToken(String token) {
        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getClaim("role").asString();
    }

    public boolean isUserEnable(String token) {
        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getClaim("enable").asBoolean();
    }

    public boolean validateToken(String token, String authenticatedUsername) {

        final String usernameFromToken = getUsernameFromToken(token);

        final boolean equalsUsername = usernameFromToken.equals(authenticatedUsername);
        final boolean tokenExpired = isTokenExpired(token);

        return equalsUsername && !tokenExpired;
    }

    private boolean isTokenExpired(String token) {

        final Date expirationDateFromToken = getExpirationDateFromToken(token);
        return expirationDateFromToken.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {

        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getExpiresAt();
    }

    private DecodedJWT getDecodedJWT(String token) {

        final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes())).build();

        return jwtVerifier.verify(token);
    }

}
