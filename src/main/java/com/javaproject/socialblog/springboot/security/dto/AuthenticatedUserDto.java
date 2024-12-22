package com.javaproject.socialblog.springboot.security.dto;

import com.javaproject.socialblog.springboot.model.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

    private String name;

    private String username;

    private String password;

    private UserRole userRole;

}
