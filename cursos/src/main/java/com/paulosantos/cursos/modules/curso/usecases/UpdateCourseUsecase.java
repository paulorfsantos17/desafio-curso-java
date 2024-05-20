package com.paulosantos.cursos.modules.curso.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulosantos.cursos.exceptions.CourseNotFoundException;
import com.paulosantos.cursos.modules.curso.CourseEntity;
import com.paulosantos.cursos.modules.curso.CourseRepository;
import com.paulosantos.cursos.modules.curso.dto.UpdateCourseRequestDTO;

import java.util.UUID;

@Service
public class UpdateCourseUsecase {

  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id, UpdateCourseRequestDTO updateCourseRequestDTO) {
    CourseEntity course = this.courseRepository.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });

    course.setName(updateCourseRequestDTO.name());
    course.setCategory(updateCourseRequestDTO.category());

    this.courseRepository.save(course);

  }
}
