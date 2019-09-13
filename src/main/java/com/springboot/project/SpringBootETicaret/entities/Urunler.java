package com.springboot.project.SpringBootETicaret.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Urunler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Urun Adi Bos Birakilamaz")
	private String urunadi;
	
	@NotEmpty(message = "Aciklama Bos Birakilamaz")
	private String aciklama;
	
	@NotEmpty(message = "Fiyat Birakilamaz")
	private String fiyat;
	
	private Integer satanid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrunadi() {
		return urunadi;
	}

	public void setUrunadi(String urunadi) {
		this.urunadi = urunadi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}

	public Integer getSatanid() {
		return satanid;
	}

	public void setSatanid(Integer satanid) {
		this.satanid = satanid;
	}
	
	
}
