package com.paulosantos.cursos.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosantos.cursos.modules.curso.CourseEntity;
import com.paulosantos.cursos.modules.curso.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public void execute(CourseEntity courseEntity) {
    courseRepository.save(courseEntity);
  }
}
