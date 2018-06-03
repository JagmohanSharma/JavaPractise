package com.example.javapractise.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycle implements InitializingBean, DisposableBean {

    @Autowired
            private Test2 test2;

    LifeCycle() {
        System.out.println(test2);
        System.out.println("Constructor...");
    }

    {
        System.out.println("instance block");
    }

    static {
        System.out.println("static block");
    }

    @PostConstruct
    public void init() {
        System.out.println(test2);
        System.out.println("post construct annotation");
    }

    @PreDestroy
    public void close() {
        System.out.println(test2);
        System.out.println("pre destroy annotation");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(test2);
        System.out.println("destroy disposable bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(test2);
        System.out.println("afterPropertiesSet");
    }

    public void intiDefault() {
        System.out.println(test2);
        System.out.println("init default");
    }

    public void intiDefaultDestroy() {
        System.out.println(test2);
        System.out.println(" default destroy");
    }

    public String testMethod() {
        return "string";
    }
}
