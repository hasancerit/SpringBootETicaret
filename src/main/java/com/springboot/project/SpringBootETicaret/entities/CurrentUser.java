package com.springboot.project.SpringBootETicaret.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class CurrentUser {
	private User user;
	
	@PreDestroy
	public void dest(){
		System.out.println("PRE DEST CUSER");
	}
	
	@PostConstruct
	public void cons(){
		System.out.println("POST CONST CUSER");
	}
	
	public CurrentUser() {
		System.out.println("OLUSTU CUSER:"+this.toString());
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
