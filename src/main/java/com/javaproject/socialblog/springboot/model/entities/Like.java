package com.javaproject.socialblog.springboot.model.entities;

import com.javaproject.socialblog.springboot.model.enums.LikeType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "likes")
public class Like {

    @Id
    private String id;

    @NotNull
    private LikeType type; // e.g., POST, COMMENT

    @NotNull
    @Indexed
    private String userId;

    @NotNull
    @Indexed
    private String contentId; // ID of the post or comment

    @CreatedDate
    @Indexed
    private Instant createdAt;

    public Like(String userId, String contentId, LikeType type) {
        this.userId = userId;
        this.contentId = contentId;
        this.type = type;
        this.createdAt = Instant.now();
    }
}