package com.javaproject.socialblog.springboot.service;

import com.javaproject.socialblog.springboot.model.entities.Post;
import com.javaproject.socialblog.springboot.model.dtos.post.PostRequest;
import com.javaproject.socialblog.springboot.model.dtos.post.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    Page<PostResponse> getAllPosts(Pageable pageable);

    Post getPostById(String id);

    List<PostResponse> getMyPosts();

    Page<PostResponse> getPostsByUser(String id, Pageable pageable);

    List<PostResponse> getPostsByUser(String id);

    Post createPost(PostRequest post);

    Post updatePost(String id, PostRequest postDetails);

    void deletePost(String id);

    void deleteNullComment(String id);

    List<PostResponse> searchPosts(String keyword, List<String> tags);

    Page<PostResponse> getPostsByMostLikes(Pageable pageable);

    Page<PostResponse> getRelatedPosts(String tag, String postId,Pageable pageable);

    String deletePostR(String id);
}

