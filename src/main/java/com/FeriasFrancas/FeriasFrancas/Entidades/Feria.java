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
@Table(name="ferias")
public class Feria { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String nombre;

    
    
    @NotBlank(message = "Campo obligatorio")
    private String dias;

    //@NotBlank 
    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")  
     
    private Time horaApertura;
    
    
    //@NotBlank
    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")     
    private Time horaCierre;

    
    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String direccion;

      
}
