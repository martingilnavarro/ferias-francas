package com.FeriasFrancas.FeriasFrancas.Entidades;


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

    
  //  @NotNull(message = "Debe elegir un valor")  // investigar como seleccionar dias de la semana
  //   private String diasDeLaSemana;

    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")
    private int horaApertura;
    
    @Temporal(TemporalType.TIME)
    @NotNull(message = "Campo obligatorio")
    private int horaCierre;

    private String direccion;
    

    @NotBlank(message = "Campo obligatorio")
    @Size(max = 250, message= "Nombre demasiado largo")
    private String localidad;
      
}
