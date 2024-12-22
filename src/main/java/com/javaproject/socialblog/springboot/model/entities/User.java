package com.javaproject.socialblog.springboot.model.entities;

import com.javaproject.socialblog.springboot.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @Indexed(unique = true)
    private String email;

    private String hashedPassword;

    private String name;

    private String avatarLink;

    private String bio;

    private Set<String> socialLinks = new HashSet<>();

    private String verifyCode;

    private boolean enabled;

    private UserRole userRole;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    // Relations
    private Set<String> followerIds = new HashSet<>();

    private Set<String> followingIds = new HashSet<>();

    private Set<String> postIds = new HashSet<>();

    private Set<String> commentIds = new HashSet<>();

    private Set<String> likeIds = new HashSet<>();

    private Set<String> notificationIds = new HashSet<>();
}