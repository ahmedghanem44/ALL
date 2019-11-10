package com.beans;

import java.io.Serializable;
import java.util.List;

public class CoffeeType implements Serializable{
	
	private int typeId ;
	private String typeName;
	private List<Coffee> coffee;
	
	public int getcId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List getCoffe() {
		return coffee;
	}
	public void setCoffe(List<Coffee> coffee) {
		this.coffee = coffee;
	}
	
	
	

}
