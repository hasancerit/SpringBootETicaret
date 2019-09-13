package com.springboot.project.SpringBootETicaret.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.SpringBootETicaret.entities.Urunler;
import com.springboot.project.SpringBootETicaret.entities.User;

public interface UrunlerDao extends JpaRepository<Urunler, Integer>{

}
