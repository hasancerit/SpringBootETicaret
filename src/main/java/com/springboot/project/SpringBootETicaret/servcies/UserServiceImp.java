package com.springboot.project.SpringBootETicaret.servcies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.SpringBootETicaret.entities.User;
import com.springboot.project.SpringBootETicaret.repositories.UserDao;

@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public User findByUsername(String userName) {
		return userDao.findByUsername(userName);
	}

	@Override
	public void userEkle(User user) {
		userDao.save(user);
	}
	
	
}
