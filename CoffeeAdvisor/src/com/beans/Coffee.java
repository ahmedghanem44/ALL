package com.beans;

import java.io.Serializable;

public class Coffee implements Serializable{
	
	private int cId ;
	private String cName;
	
	
	public Coffee(String cName) {
		
		this.cName = cName;
	}

	public int getId() {
		return this.cId;
	}
	
	public String getName() {
		return this.cName;
	}
	
	public void setId(int id) {
		this.cId = id;
	}
	
	public void setName(String name) {
		this.cName = name;
	}

}
