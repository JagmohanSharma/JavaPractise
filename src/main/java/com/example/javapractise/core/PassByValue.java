package com.example.javapractise.core;

public class PassByValue {

    public void method1(int x, Test t, Test t1) {

        x = 10;
        t.var = 20;
        t1 = new Test();
        t1.var = 34;
    }

    public static void main(String[] args) {
        int y = 4;
        PassByValue p = new PassByValue();
        Test t = p.new Test();
        Test t1 = p.new Test();
        t.var = 66;
//        t1.var = 44;
        p.method1(y, t, t1);

        System.out.println(y + " " + t.var + " " + t1.var);
    }

    class Test{
        int var;
    }
}
