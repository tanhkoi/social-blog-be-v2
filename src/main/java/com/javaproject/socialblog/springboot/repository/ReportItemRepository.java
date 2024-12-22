package com.javaproject.socialblog.springboot.repository;

import com.javaproject.socialblog.springboot.model.entities.ReportItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportItemRepository extends MongoRepository<ReportItem, String> {
}
