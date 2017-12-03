package com.gtgsantos.domain.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gtgsantos.domain.lesson.Lesson;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COU_COURSE")
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    
    public Course() {
        this.additionalCourses = new ArrayList<Course>();
        this.lessons = new ArrayList<Lesson>();
    }
    
    @Id
    @GeneratedValue
    @Column(name = "COU_ID")
    private Long pk;
    
    @Column(name="COU_DS_NAME")
    private String name;
    
    @OneToMany(mappedBy="course", targetEntity = Lesson.class)
    private List<Lesson> lessons;
    
    @OneToMany(mappedBy="master", targetEntity = Course.class)
    private List<Course> additionalCourses;
    
    @ManyToOne
    @JoinColumn(name = "COU_FK_MASTER")
    private Course master;
    
    public void addAdditionalCourse(Course course) {
        if (!course.getPk().equals(this.getPk())) {
            course.setMaster(this);
        }
        this.getAdditionalCourses().add(course);
    }
    
    public void addAdditionalLesson(Lesson lesson) {
        lesson.setCourse(this);
        this.getLessons().add(lesson);
    }


}
