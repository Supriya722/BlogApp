package com.blogApp.blog.services;

import java.util.List;

//import com.blogApp.blog.entities.Post;
import com.blogApp.blog.payloads.PostDto;
import com.blogApp.blog.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost (PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost (PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto>getPostsByUser(Integer userId);

	
	//search posts using keyword
    List<PostDto> searchPosts(String keyword);


}
