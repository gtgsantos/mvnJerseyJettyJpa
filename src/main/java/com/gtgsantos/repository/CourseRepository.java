package com.gtgsantos.repository;

import com.gtgsantos.domain.course.Course;

public class CourseRepository extends AbstractRepository<Course> {

    public CourseRepository() {
        super(Course.class);
    }
    
}
