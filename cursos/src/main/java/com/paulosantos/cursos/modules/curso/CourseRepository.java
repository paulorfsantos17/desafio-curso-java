package com.paulosantos.cursos.modules.curso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}