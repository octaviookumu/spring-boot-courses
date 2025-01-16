package com.octaviookumu.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {


    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    // theCode - what the user entered
    // theConstraintValidatorContext - we can use to give additional error messages if needed
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {


        boolean result = theCode.startsWith(coursePrefix);

        return false;
    }
}
