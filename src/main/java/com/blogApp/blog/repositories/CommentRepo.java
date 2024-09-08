package com.blogApp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
