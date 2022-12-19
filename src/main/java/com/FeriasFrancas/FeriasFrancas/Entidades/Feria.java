package com.FeriasFrancas.FeriasFrancas.Entidades;

import java.sql.Time;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="feria")
public class Feria { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String nombre;

    
   @NotNull(message = "Debe elegir un valor")  
    private String dias;

    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")
    private Time horaApertura;
    
    /**
     *
     */
    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")
    private Time horaCierre;

    private String direccion;

      
}
