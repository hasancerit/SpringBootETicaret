package com.springboot.project.SpringBootETicaret.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.project.SpringBootETicaret.entities.CurrentUser;
import com.springboot.project.SpringBootETicaret.entities.Urunler;
import com.springboot.project.SpringBootETicaret.servcies.UrunlerService;
import com.springboot.project.SpringBootETicaret.servcies.UserService;

@org.springframework.stereotype.Controller
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UrunlerService urunlerService;
	
	@Autowired
	CurrentUser cUser;

	@GetMapping("/urunsat")
	public String urunSat(Model model) {
		System.out.println("CUSER SAT:"+cUser.toString());

		model.addAttribute("newurun",new Urunler());
		model.addAttribute("cUser",cUser.getUser());
		return "urunsat";
	}
	
	@PostMapping("/urunsat")
	public String urunSatHandle(@Valid @ModelAttribute("newurun") Urunler urun, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "urunsat";
		}
		
		urun.setSatanid(cUser.getUser().getId());
		urunlerService.urunEkle(urun);
		model.addAttribute("cUser",cUser.getUser());
		return "anasayfa";
	}
	
	@GetMapping("/urunler")
	public String urunler(Model model) {
		List<Urunler> list = urunlerService.getAll();
		model.addAttribute("urunlist",list);
		return "urunler";
	}
	
	@GetMapping("/urunal")
	public String urunlerHdnle(Model model,@RequestParam String id) {
		model.addAttribute("cUser",cUser.getUser());
		urunlerService.urunSil(Integer.parseInt(id));
		return "anasayfa";
	}
	
	@GetMapping("/anasayfa")
	public String anasayfa(Model model) {
		model.addAttribute("cUser",cUser.getUser());
		return "anasayfa";
	}
}
