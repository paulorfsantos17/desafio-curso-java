package com.paulosantos.cursos.modules.curso.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseRequestDTO(
    @NotBlank(message = "o campo [nome] não pode ser vazio.") @Length(min = 3, message = "O nome precisa de no minímo 3 caracteres.") String name,

    @NotBlank(message = "o campo [categoria] não pode ser vazio.") String category

) {
}
