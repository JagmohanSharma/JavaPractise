package com.example.javapractise.core;

public class Overloading {

    //A final variable that is not initialized at the time of declaration is known as blank final variable.
    final int limit;

    //It can be initialized only in constructor.
    public Overloading() {
        limit = 0;
    }

    //Can we declare a constructor final?
//    No, because constructor is never inherited.

    void sum(long a,int b){System.out.println("b method invoked");}

    void test(Object o) {
        System.out.println("Object");
    }

    void test(String s) {
        System.out.println("String");
    }
   /* void test(Number i) {
        System.out.println("Number");
    }*/

    void test(Double i) {
        System.out.println("double primitive");
    }

    /*void test(int i) {
        System.out.println("int primitive");
    }*/

    //Learning - type promotion will be taken over boxing/unboxing wrapper classes

    public static void main(String[] args) {
        Overloading o = new Overloading();

        //One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.
//        o.sum(1,2.0d);

        o.sum(1,2);
        o.test( (long)1);

    }
}
