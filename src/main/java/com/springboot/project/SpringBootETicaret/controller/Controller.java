package com.springboot.project.SpringBootETicaret.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.project.SpringBootETicaret.entities.CurrentUser;
import com.springboot.project.SpringBootETicaret.entities.User;
import com.springboot.project.SpringBootETicaret.servcies.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@PreDestroy
	public void cons() {
		System.out.println("CONTROLLER SİLİNDİ");
	}
	@Autowired
	UserService userService;
	
	@Autowired
	CurrentUser cUser;
	
	@GetMapping("/")
	public String getTest(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "giris";
	}

	@PostMapping(value = "/giris")
	public String girisDene(@Valid @ModelAttribute("user") User gelenUser ,BindingResult bindingResult,Model model) {			
		//Validation Hata Durumu
		if(bindingResult.hasErrors()) {
			return "giris";
		}
		
		String username = gelenUser.getUsername();
		String password = gelenUser.getPassword();
		User user = userService.findByUsername(username);

		//Veritabanı basari durumu
		if(user != null && password.equals(user.getPassword())) {
			model.addAttribute("cUser",user);
			cUser.setUser(user);
			System.out.println("CUSER GİRİS:"+cUser.toString());
			System.out.println("CONTROLLER GİRİS:"+this.toString());

			return "anasayfa";
		}
		//Veri Tabani hata durumu
		if(user == null) {
			model.addAttribute("booluser",true);
		}else if(!password.equals(user.getPassword())) {
			model.addAttribute("boolpass",true);
		}
		return "giris";
	}
	
	@GetMapping("/cikis")
	public String cikis(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		cUser.setUser(new User());
		return "giris";
	}
	
}
