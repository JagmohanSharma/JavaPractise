package com.example.javapractise.multithreading.pattern1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    /*private static void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public synchronized static void m1() {
        do_stuff();
    }
    public synchronized static void m2() {
        do_stuff();
    }*/

    private void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public void run() {
        do_stuff();
    }

    public synchronized void m1() {
    }
    public synchronized void m2() {
        m1();
    }

    public static void main(String[] args) {
        /*Thread t1 = new Thread() {
            public void run() {
                Test s = new Test();
                s.m1();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Test s = new Test();
                s.m2();
            }
        };
        t1.start();
        t2.start();
        System.out.println("Done");*/


        /*Thread[] task_array = {new Thread(new Test()),
                new Thread(new Test()),
                new Thread(new Test()),
                new Thread(new Test())};
        task_array[0].start();
        task_array[1].start();
        task_array[2].run();
        task_array[3].run();
        System.out.println("Done");*/

        Test test = new Test();
        test.m2();
        System.out.println("done");


        B b = new B();
        System.out.println(b.f1());

        Try t = new Try();
        System.out.println(t.f1(1));
    }
}

/*
class Base {
    public String f1(int a) {
        return "f1";
    }
    public String f2() {
        return f1(1);
    }
}
*/

/*class Derived extends Base {
    public String f1(String a) {
        return "f1t";
    }
    public String f2() {
        return f1(1);
    }
}*/

/*class Base {
    public String f1() {
        return "fb" + super.f1();
    }
}

class Try extends Base {
    public String f1() {
        return "ft";
    }
}*/

class B {
    public String f1() {
        return "fb";
    }
}

class D1 extends B {
}

class D2 extends D1 {
    public String f1() {
        return "fd2";
    }
}

class Base {
    public String f1(int a) {
        return "fb";
    }
}

class Try extends Base {
    public String f1(String b) {
        return "ft";
    }
}