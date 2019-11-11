package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.Course;

public interface CourseRepo extends CrudRepository<Course, Long> {

}
