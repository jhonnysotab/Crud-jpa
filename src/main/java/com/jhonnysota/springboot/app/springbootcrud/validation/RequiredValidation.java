package com.jhonnysota.springboot.app.springbootcrud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<IsRequired,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && value.isBlank() && value.isEmpty()){
            return true;
        }    
        return false;
    }

}
