package com.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Machine")
public class Machine implements Serializable {

	private static final long serialVersionUID = 3109160088878846764L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hourly_rent")
	private double hourly_rent;
	
	@Column(name = "max_hours_per_day")
	private double max_hours_per_day;
	
	
//	@ManyToOne
//	private Timesheet ts;
	
	public Machine()
	{
	}	
	
	@Override
	public String toString() 
	{
		return	"code : " + code + 
				"\ndescription : " + description +
				"\nhourly rent: " + hourly_rent + 
				"\nmax hours per day: " + max_hours_per_day;
	}
	

	public int getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHourly_rent() {
		return hourly_rent;
	}

	public void setHourly_rent(double hourly_rent) {
		this.hourly_rent = hourly_rent;
	}

	public double getMax_hours_per_day() {
		return max_hours_per_day;
	}

	public void setMax_hours_per_day(double max_hours_per_day) {
		this.max_hours_per_day = max_hours_per_day;
	}	
		
	
	



}
