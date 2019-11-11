package com.nemo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nemo.components.CapitalsBean;

@Component
public class CapitalsService {
	
//	@Autowired
	private HashMap<String,String> cbMap = new HashMap<String,String>();
	
	public void addCapital(String country,String capital ) {
		
		cbMap.put(country, capital);
	}
	
	public String getCapitalByCountry(String country) {
		
		return cbMap.get(country);
	}
	
	public void deleteCapitalByCountry(String country) {
		
		cbMap.remove(country);
	}
	
	public void editCapitalbyCountry(String country,String newCapital) {
		
		cbMap.replace(country, newCapital);
	}
	
	public void getCapitalsList() {
		
		Set<String> keySet = cbMap.keySet();
		Iterator<String> itr = keySet.iterator();
		int index = 1 ;
		while (itr.hasNext()) {
			String coun = itr.next().toString();
			String cap = getCapitalByCountry(coun);
			System.out.println(index+". "+coun+": " + cap+".");
			index++;
		}
	}
	

}
