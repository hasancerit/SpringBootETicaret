package com.springboot.project.SpringBootETicaret.servcies;

import java.util.List;

import com.springboot.project.SpringBootETicaret.entities.Urunler;

public interface UrunlerService {
	void urunEkle(Urunler urun);
	
	List<Urunler> getAll();
	
	void urunSil(int id);
}
