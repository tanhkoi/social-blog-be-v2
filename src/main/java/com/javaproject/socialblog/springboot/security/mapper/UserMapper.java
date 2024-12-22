package com.javaproject.socialblog.springboot.security.mapper;

import com.javaproject.socialblog.springboot.model.entities.User;
import com.javaproject.socialblog.springboot.security.dto.AuthenticatedUserDto;
import com.javaproject.socialblog.springboot.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(RegistrationRequest registrationRequest);

    AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

    User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
