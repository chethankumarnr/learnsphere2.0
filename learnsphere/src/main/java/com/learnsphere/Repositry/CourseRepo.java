package com.learnsphere.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.Entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>
{

}
