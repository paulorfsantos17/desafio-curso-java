package com.paulosantos.cursos.modules.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class GetAllCourseResponseDTO {
  private UUID id;
  private String name;
  private String category;
  private String active;
}
