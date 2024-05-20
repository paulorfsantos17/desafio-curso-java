package com.paulosantos.cursos.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosantos.cursos.exceptions.CourseNotFoundException;
import com.paulosantos.cursos.modules.curso.CourseRepository;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    this.courseRepository.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });

    this.courseRepository.deleteById(id);
  }

}
