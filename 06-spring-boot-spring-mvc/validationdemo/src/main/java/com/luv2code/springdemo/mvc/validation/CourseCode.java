package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// CourseCodeConstraintValidator -> helper class that contains business rules/ validation logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {


    // define default course code
    public String value()  default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    // Groups: can groups related constraints
    public Class<?>[] groups() default {};

    // define default payloads
    // Payloads: provide custom details about validation failure (severity level, error code etc)
    public Class<? extends Payload>[] payload() default {};

}
