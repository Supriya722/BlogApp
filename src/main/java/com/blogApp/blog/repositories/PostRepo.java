package com.blogApp.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogApp.blog.entities.Category;
import com.blogApp.blog.entities.Post;
import com.blogApp.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
    
	List<Post> findByUser(User user);    
	List<Post> findByCategory(Category category);
   
	@Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword%")
	List<Post> searchPostsByTitle(@Param("keyword") String keyword);



}
