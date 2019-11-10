package com.beans;

import java.io.Serializable;

public class Coffee implements Serializable{
	
	private int id ;
	private String cName;
	
	public Coffee() {
		
	}
	
	
	public Coffee(String cName) {
		
		this.cName = cName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}



}
