package com.javaproject.socialblog.springboot.repository;

import com.javaproject.socialblog.springboot.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByVerificationCode(String code);

    User findByEmail(String email);

}
