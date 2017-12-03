package com.gtgsantos.repository;

import com.gtgsantos.domain.lesson.Lesson;

public class LessonRepository extends AbstractRepository<Lesson> {

    protected LessonRepository() {
        super(Lesson.class);
    }
    
}
