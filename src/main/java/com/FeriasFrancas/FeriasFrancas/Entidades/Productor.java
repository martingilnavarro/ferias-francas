package com.FeriasFrancas.FeriasFrancas.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "productores")
public class Productor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Campo obligatorio")
  @Size(max = 100, message = "Nombre demasiado largo")
  private String nombre;

  @NotNull(message = "Campo Obligatorio")
  private Long telefono;

  @NotBlank(message = "campo obligatorio")
  @Size(max = 100, message = "nombre demasiado largo")
  private String localidad;
}
