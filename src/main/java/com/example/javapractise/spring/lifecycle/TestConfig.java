package com.example.javapractise.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean(initMethod = "intiDefault", destroyMethod = "intiDefaultDestroy")
    public LifeCycle lifeCycle() {
        return new LifeCycle();
    }


    @Bean
    public Test2 test2() {
        return new Test2();
    }

}
