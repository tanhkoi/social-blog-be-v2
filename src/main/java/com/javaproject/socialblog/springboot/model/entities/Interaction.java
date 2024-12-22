package com.javaproject.socialblog.springboot.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Post post;

    private String type;

    private Date createdAt;

}
