package com.javaproject.socialblog.springboot.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;

    private String title;

    private String message;

    private boolean read;

    private String userId;

    private String postId;

    @CreatedDate
    private Instant createdAt;

    public Notification(String userId, String title, String message) {
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.read = false;
        this.postId = null;
        this.createdAt = Instant.now();
    }

    public Notification(String userId, String postId, String title, String message) {
        this.userId = userId;
        this.postId = postId;
        this.title = title;
        this.message = message;
        this.read = false;
        this.createdAt = Instant.now();
    }
}
