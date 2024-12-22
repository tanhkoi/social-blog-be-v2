package com.javaproject.socialblog.springboot.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bookmarks")
public class Bookmark {

    @Id
    private ObjectId id;

    private String userId;

    private String postId;

    private LocalDateTime bookmarkedAt = LocalDateTime.now();

}
