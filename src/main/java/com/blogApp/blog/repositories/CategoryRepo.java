package com.blogApp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
