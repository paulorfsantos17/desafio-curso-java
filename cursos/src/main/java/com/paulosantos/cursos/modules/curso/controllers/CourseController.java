package com.paulosantos.cursos.modules.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulosantos.cursos.modules.curso.CourseEntity;
import com.paulosantos.cursos.modules.curso.dto.CreateCourseRequestDTO;
import com.paulosantos.cursos.modules.curso.dto.GetAllCourseResponseDTO;
import com.paulosantos.cursos.modules.curso.enums.Active;
import com.paulosantos.cursos.modules.curso.usecases.CreateCourseUseCase;
import com.paulosantos.cursos.modules.curso.usecases.DeleteCourseUseCase;
import com.paulosantos.cursos.modules.curso.usecases.GetAllCourseUsecase;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private GetAllCourseUsecase getAllCourseUsecase;

  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
    try {
      CourseEntity courseEntity = CourseEntity.builder()
          .name(createCourseRequestDTO.name())
          .category(createCourseRequestDTO.category())
          .active(Active.UNCHECK)
          .build();

      this.createCourseUseCase.execute(courseEntity);

      return ResponseEntity.status(HttpStatus.CREATED).build();

    } catch (Exception e) {
      System.err.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @GetMapping("/")
  public ResponseEntity<Object> getAllCourse() {
    try {
      List<CourseEntity> listCourse = this.getAllCourseUsecase.execute();

      List<GetAllCourseResponseDTO> ListCourseResponse = listCourse.stream().map(course -> {
        return GetAllCourseResponseDTO.builder()
            .id(course.getId())
            .name(course.getName())
            .category(course.getCategory())
            .active(course.getActive().toString())
            .build();
      }).collect(Collectors.toList());

      return ResponseEntity.status(HttpStatus.OK).body(ListCourseResponse);

    } catch (

    Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCourse(@PathVariable UUID id) {
    try {
      this.deleteCourseUseCase.execute(id);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
