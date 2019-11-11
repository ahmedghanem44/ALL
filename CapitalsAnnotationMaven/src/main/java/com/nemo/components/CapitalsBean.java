package com.nemo.components;

import org.springframework.stereotype.Component;

@Component
public class CapitalsBean {
	
	private int id;
	private String country;
	private String capital;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	

}
