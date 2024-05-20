package com.paulosantos.cursos.modules.curso.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record UpdateCourseRequestDTO(
                @Length(min = 3, message = "O nome precisa de no minímo 3 caracteres.") String name,
                @NotBlank String category

) {
}
