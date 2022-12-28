package com.FeriasFrancas.FeriasFrancas.Entidades;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "productos")
public class Producto {

 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Campo Obligatorio")
 @Size(max = 100, message = "Nombre demasiado largo")
  private String nombre;


 
@Range(min = 1, message = "El precio no puede ser cero")
@NotNull(message = "Campo requerido")
  private double precio;

  @NotBlank(message = "Campo obligatorio")
  @Size(max = 100, message = "Nombre demasiado largo")
  private String unidadMedida;

  
}
