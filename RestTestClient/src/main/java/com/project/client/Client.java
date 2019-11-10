package com.project.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.model.Student;

@Component
public class Client implements CommandLineRunner{
	
	@Autowired
	RestTemplate template;
	
	private void getStudent(){

			Student[] students =  template.getForObject("http://localhost:8080/students/getAll", Student[].class);
			List<Student> list =  Arrays.asList(students);
			System.out.println(list.get(2).getFname());
		


	}

	@Override
	public void run(String... args) throws Exception {
		
		getStudent();
	}

}
