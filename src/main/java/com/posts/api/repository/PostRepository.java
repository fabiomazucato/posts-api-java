package com.posts.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.posts.api.entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}