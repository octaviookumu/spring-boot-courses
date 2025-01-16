package com.octaviookumu.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // where can you apply this new annotation
@Retention(RetentionPolicy.RUNTIME) // how long will the annotation be used
public @interface CourseCode {

    // define default course code - value user can pass in. If they don't the default value is 'LUV'
    public String value() default "LUV";

    // define default error message - message user can pass in. If they don't the default message is 'must start with LUV'
    public String message() default "must start with LUV";

    // define default groups - where you can group validation constraints together
    public Class<?>[] groups() default {};

    // define default payloads - where you can give additional info about the validation failure(severity level, error code e.t.c)
    public Class<? extends Payload>[] payload() default {};

}
