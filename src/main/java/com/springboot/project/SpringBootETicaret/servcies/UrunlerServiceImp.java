package com.springboot.project.SpringBootETicaret.servcies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.SpringBootETicaret.entities.Urunler;
import com.springboot.project.SpringBootETicaret.repositories.UrunlerDao;

@Service
@Transactional
public class UrunlerServiceImp implements UrunlerService{
	@Autowired
	UrunlerDao urunlerDao;
	
	@Override
	public void urunEkle(Urunler urun) {
		urunlerDao.save(urun);
	}

	@Override
	public List<Urunler> getAll() {
		return urunlerDao.findAll();
	}

	@Override
	public void urunSil(int id) {
		urunlerDao.deleteById(id);
	}
	
}
