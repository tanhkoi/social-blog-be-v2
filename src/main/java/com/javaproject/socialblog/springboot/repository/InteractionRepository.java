package com.javaproject.socialblog.springboot.repository;

import com.javaproject.socialblog.springboot.model.entities.Interaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InteractionRepository extends MongoRepository<Interaction, String> {
}
