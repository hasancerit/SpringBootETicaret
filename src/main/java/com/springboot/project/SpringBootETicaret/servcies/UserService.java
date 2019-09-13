package com.springboot.project.SpringBootETicaret.servcies;

import java.util.List;

import com.springboot.project.SpringBootETicaret.entities.User;

public interface UserService {
	User findByUsername(String userName);
	
	void userEkle(User user);
}
