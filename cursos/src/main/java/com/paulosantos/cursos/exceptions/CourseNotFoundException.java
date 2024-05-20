package com.paulosantos.cursos.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Curso Não existe.");
  }
}
