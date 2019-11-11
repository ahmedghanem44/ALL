package com.nemo.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Course implements Serializable {
	
	private static final long serialVersionUID = 5487795183970417552L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="course_id")
	private long id ;
	
	@Column(name="course_name")
	private String name;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	

}
