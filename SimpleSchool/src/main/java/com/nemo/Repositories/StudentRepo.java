package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.Student;

public interface StudentRepo extends CrudRepository<Student,Long> {

}
