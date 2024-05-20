package com.paulosantos.cursos.modules.curso;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.paulosantos.cursos.modules.enums.Active;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Data
@Entity(name = "course")
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  private String name;

  @NotBlank
  private String category;

  private Active active;

  @CreationTimestamp
  @Column(name = "updated_at")
  private LocalDateTime createAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updateAT;
}
