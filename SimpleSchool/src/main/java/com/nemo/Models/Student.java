package com.nemo.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Students")
public class Student implements Serializable {

	private static final long serialVersionUID = -4511942858776609374L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column
	private long id;

	
	@Column
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="course_id)"))
	private Set<Course> courses;
	
	@Column
	@OneToMany(mappedBy = "student", cascade=CascadeType.ALL, fetch=FetchType.LAZY , orphanRemoval = true)
	private Personal personal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	
}
