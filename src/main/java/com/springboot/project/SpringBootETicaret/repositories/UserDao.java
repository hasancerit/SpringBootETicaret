package com.springboot.project.SpringBootETicaret.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.project.SpringBootETicaret.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
