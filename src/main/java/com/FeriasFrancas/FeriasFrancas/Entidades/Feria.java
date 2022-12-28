package com.FeriasFrancas.FeriasFrancas.Entidades;
import java.sql.Time;
import java.util.Date;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="ferias")
public class Feria { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String nombre;

    
    @NotNull
    @NotBlank(message = "Campo obligatorio")
    private String dias;

    @Temporal(TemporalType.TIME)
    @NotNull
    @NotBlank(message = "Campo obligatorio")   
    private Time horaApertura;
    
    
   @Temporal(TemporalType.TIME)
    @NotNull
    @NotBlank(message = "Campo obligatorio")  
    private Time horaCierre;

    @NotNull
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String direccion;

      
}
