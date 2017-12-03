package com.gtgsantos.test.course;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.gtgsantos.domain.course.Course;
import com.gtgsantos.repository.CourseRepository;

public class IncludeCourseTest {
    
    private static CourseRepository repository = new CourseRepository();

    @Test
    public void insertOne() {
        Course course = new Course();
        course.setName("Java 101");
        
        repository.save(course);
        
        Course course2 = repository.find(course.getPk());
        assertThat(course, is(course2));
    }
    
    
    @Test
    public void insertTwo() {
        Course course = new Course();
        course.setName("Java 101");
        repository.save(course);
         
        Course course1 = new Course();
        course1.setName("Java 102");
        course1.addAdditionalCourse(course);
        repository.save(course1);
        
        Course course2 = repository.find(course.getPk());
        Course course3 = repository.find(course1.getPk());
        List<Course> listCourses = repository.list();
        
        assertThat(course3.getAdditionalCourses().size(), is(1));
        assertThat(course2.getMaster(), is(course3));
        assertThat(listCourses.size(), is(3)); // because test one already inserted one value
        
    }
    
    
}
