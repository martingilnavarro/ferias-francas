package com.FeriasFrancas.FeriasFrancas.validaciones;

import com.FeriasFrancas.FeriasFrancas.dto.RegistroDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmarValidator  implements ConstraintValidator<Confirmar, Object>{

    @Override
    public void initialize(final Confirmar constrainrAnnotation){
        //
    }

    @Override
    public boolean isValid(final Object object, final ConstraintValidatorContext context){
        final RegistroDto registro = (RegistroDto) object;
        boolean esValido = registro.getPassword().equals(registro.getConfirmar());

        if(! esValido){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("confirmar").addConstraintViolation();
        }
        return esValido;
    }
}
