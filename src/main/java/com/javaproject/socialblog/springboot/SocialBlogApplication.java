package com.javaproject.socialblog.springboot;

import com.javaproject.socialblog.springboot.model.entities.Like;
import com.javaproject.socialblog.springboot.model.enums.LikeType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialBlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(SocialBlogApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui/index.html");

    }

//    @Bean
//    CommandLineRunner run() {
//        return args -> {
//            try {
//                Like like = new Like();
//                like.setUserId("67190dcda16bd00554e8cddc");
//                like.setType(LikeType.POST);
//                like.setContentId("675fd2e6655d9498625e06bd");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        };
//    }

}
