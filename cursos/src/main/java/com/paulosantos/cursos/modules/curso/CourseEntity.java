package com.paulosantos.cursos.modules.curso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.paulosantos.cursos.modules.curso.enums.Active;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@Entity(name = "course")
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O campo [nome] não pode ser vazio.")
  private String name;

  @NotBlank(message = "O campo [category] não pode ser vazio.")
  private String category;

  private Active active;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updateAT;
}
