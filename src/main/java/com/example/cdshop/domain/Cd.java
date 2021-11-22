package com.example.cdshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cd {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String album;
	private String band;
	private int year;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Cd() {
		super();
	}
	
	public Cd (String album, String band, int year, double price, Genre genre) {
		super();
		this.album = album;
		this.band = band;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
