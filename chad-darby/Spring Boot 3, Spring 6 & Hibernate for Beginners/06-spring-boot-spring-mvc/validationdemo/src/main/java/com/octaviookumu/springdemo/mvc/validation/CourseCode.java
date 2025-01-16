package com.octaviookumu.springdemo.mvc.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // where can you apply this new annotation
@Retention(RetentionPolicy.RUNTIME) // how long will the annotation be used
public @interface CourseCode
{
}
