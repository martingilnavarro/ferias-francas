package com.FeriasFrancas.FeriasFrancas.Entidades;

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

    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String nombre;

    private double precio;
    
    
    private String unidadMedida;
    
}
