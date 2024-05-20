package com.paulosantos.cursos.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosantos.cursos.modules.curso.CourseRepository;
import com.paulosantos.cursos.modules.curso.CourseEntity;

import java.util.List;

@Service
public class GetAllCourseUsecase {
  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> execute() {
    return courseRepository.findAll();
  }

}
