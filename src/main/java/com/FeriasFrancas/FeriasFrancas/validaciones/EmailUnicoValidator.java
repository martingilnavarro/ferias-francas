package com.FeriasFrancas.FeriasFrancas.validaciones;
import com.FeriasFrancas.FeriasFrancas.Repositorios.*;
import com.FeriasFrancas.FeriasFrancas.dto.RegistroDto;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailUnicoValidator  implements ConstraintValidator<EmailUnico, Object>{

    @Autowired
    private UsuarioRepositorio UsuarioRepositorio;

    @Override
    public void initialize(final EmailUnico constraintAnnotation){
        //
    }

    @Override
    public boolean isValid(final Object objeto, final ConstraintValidatorContext context){
        final RegistroDto registro = (RegistroDto) objeto;
        boolean esValido = ! UsuarioRepositorio.existsByEmail(registro.getEmail());

        if(! esValido){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("email").addConstraintViolation();
        }
        return esValido;
    }
    
}
