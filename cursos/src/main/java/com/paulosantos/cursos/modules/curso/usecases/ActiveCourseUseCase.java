package com.paulosantos.cursos.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosantos.cursos.modules.curso.CourseEntity;
import com.paulosantos.cursos.modules.curso.CourseRepository;
import com.paulosantos.cursos.modules.curso.enums.Active;

import java.util.UUID;

@Service
public class ActiveCourseUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    CourseEntity courseEntity = this.courseRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException("Cannot find course");
    });

    courseEntity.setActive(Active.CHECK);

    this.courseRepository.save(courseEntity);
  }

}
