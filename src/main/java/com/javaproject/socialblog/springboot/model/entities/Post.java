package com.javaproject.socialblog.springboot.model.entities;

import com.javaproject.socialblog.springboot.model.enums.PostStatus;
import com.javaproject.socialblog.springboot.model.enums.PostVisibility;
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
@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    @Indexed
    private String title;

    @Indexed
    private String category;

    @Indexed
    private Set<String> tags = new HashSet<>();

    private String content;

    private String coverPhotoLinks;

    private PostStatus status;

    private PostVisibility visibility;

    @CreatedDate
    @Indexed
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    // Relations
    @Indexed
    private String authorId;

    private Set<String> commentIds = new HashSet<>();

    private Set<String> likeIds = new HashSet<>();
}