package com.example.javapractise.spring.lifecycle;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class Test {

    @Autowired
    private LifeCycle lifeCycle;

    @org.junit.Test
    public void test() {
        lifeCycle.testMethod();
    }


}
