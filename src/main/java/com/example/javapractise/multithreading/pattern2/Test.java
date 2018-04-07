package com.example.javapractise.multithreading.pattern2;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Thread t1 = new Thread(new Producer(linkedList, 20));
        Thread t2 = new Thread(new Consumer(linkedList, 20));

        t1.start();
        t2.start();
    }
}
