package com.jhonnysota.springboot.app.springbootcrud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jhonnysota.springboot.app.springbootcrud.entities.Product;
@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null,"Porfavor Valide el nombre se ha correcto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", null, "Porfavor Valide el nombre se ha correcto");
    }

}
