package com.gtgsantos.domain.lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gtgsantos.domain.course.Course;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LES_LESSON")
@Getter
@Setter
@EqualsAndHashCode
public class Lesson {
    
    @Id
    @GeneratedValue
    @Column(name = "LES_ID")
    private Long pk;
    
    @Column(name = "LES_DS_NAME")
    private String name;
    
    @Column(name = "LES_NU_NUMBER")
    private Integer number;
    
    @Column(name = "LES_DS_DESCRIPTION")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "COU_ID")
    private Course course;
    

}
