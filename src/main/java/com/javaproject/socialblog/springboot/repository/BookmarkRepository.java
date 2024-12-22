package com.javaproject.socialblog.springboot.repository;

import com.javaproject.socialblog.springboot.model.entities.Bookmark;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookmarkRepository extends MongoRepository<Bookmark, String> {

    List<Bookmark> findByUserId(String userId);

    boolean existsByUserIdAndPostId(String userId, String postId);

    void deleteByUserIdAndPostId(String userId, String postId);

}
