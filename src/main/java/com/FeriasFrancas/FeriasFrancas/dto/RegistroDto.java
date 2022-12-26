package com.FeriasFrancas.FeriasFrancas.dto;
import com.FeriasFrancas.FeriasFrancas.validaciones.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Confirmar
@EmailUnico
public class RegistroDto {
    
    @NotNull
    @NotEmpty(message = "Ingrese una direccion de correo electronico")
    @Email(message = "Ingrese una direccion de correo electronico valida")
    private String email;

    @NotNull 
    @NotEmpty(message = "Ingrese una contraseña")
    private String password;

    private String confirmar;
}
