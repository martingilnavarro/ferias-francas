package com.FeriasFrancas.FeriasFrancas.validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUnicoValidator.class)
@Documented
public @interface EmailUnico {
    String message() default "Ya existe un usuario con este email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    
}
