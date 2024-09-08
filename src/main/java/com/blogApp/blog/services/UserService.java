package com.blogApp.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogApp.blog.entities.User;
import com.blogApp.blog.payloads.UserDto;

@SuppressWarnings("unused")
public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto>getAllUsers();
	
	void deleteUser(Integer userId);
}
