package com.octaviookumu.springcoredemo.config;

import com.octaviookumu.springcoredemo.common.Coach;
import com.octaviookumu.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

//    @Bean("aquatic") - custom bean id
    @Bean // the bean id defaults to the method name
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
