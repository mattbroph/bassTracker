package com.mattbroph.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Verifies form data is correct using hibernate validator
 */
public interface FormValidation {

    static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();


    /**
     * Validates the object's instance variables against the hibernate annotation restrictions
     *
     * @param <T> the object to validate
     * @return the list of violations
     */
    default <T> List<String> validateFormData(T object) {

        // Create a validator factory and validator
        Validator validator = validatorFactory.getValidator();
        List<String> violationMessages = new ArrayList<>();

        // Check for hibernate validation errors
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        // Add errors to list
        for (ConstraintViolation<T> violation : violations) {
            // Add violation messages
            violationMessages.add(violation.getMessage());
        }

        return violationMessages;

    }


}

