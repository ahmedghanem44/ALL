package com.nemo.capitals;

import java.util.HashMap;

public class CapitalFinderService {
	
	HashMap<String,String> countryCap = new HashMap<String,String>();

	public HashMap<String, String> getCountryCap() {
		return countryCap;
	}
	public void setCountryCap(HashMap<String, String> countryCap) {
		this.countryCap = countryCap;
	}
	public void addCapital(String country, String capital ) {
		countryCap.put(country, capital);
	}
	public String findCapital(String country) {
		getCapitalsMap().get(country);
		return getCapitalsMap().get(country);
	}
	
	private HashMap<String, String> getCapitalsMap(){
		this.countryCap.put("egypt", "Cairo");
		this.countryCap.put("usa", "Washington DC");
		this.countryCap.put("germany","Berlin");
		this.countryCap.put("italy","Rome");
		this.countryCap.put("france","Paris");
		this.countryCap.put("india","New Delhi");
		
		return countryCap;
	}

}
