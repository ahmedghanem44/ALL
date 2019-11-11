package com.nemo.Services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.nemo.Models.Student;
import com.nemo.Repositories.StudentRepo;

public class StudentService {
	
	@Autowired StudentRepo studentRepo;
	
	public Student findStudentById(long id) {
		try {
			return (Student) studentRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			System.out.println("No Student with the given id has been found");
			return new Student();
		}
		
	}

	public Student findStudent(Student student) {
		try {
			long id = student.getId();
			return (Student) studentRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			System.out.println("No Student with the given id has been found");
			return new Student();
		}
		
	}
	
	public List<Student> listStudents(){
		return (List<Student>) studentRepo.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Student deleteStudent(Student student) {
		studentRepo.delete(student);
		return student;
	}
	
	public Student deleteStudent(long id) {
		Student deletedStudent = this.findStudentById(id);
		studentRepo.deleteById(id);
		return deletedStudent;
	}
	
//	public Student updateStudent(Student student) {
//		Student toUpdate = this.findStudentById(student.getId());
//		toUpdate.set
//	}

}
