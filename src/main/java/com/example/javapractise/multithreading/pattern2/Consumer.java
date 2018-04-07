package com.example.javapractise.multithreading.pattern2;

import java.util.LinkedList;

public class Consumer implements Runnable {

    private LinkedList list;

    private int size;

    public Consumer(LinkedList list, int size) {
        this.list = list;
        this.size = size;
    }


    @Override
    public void run() {
        while(true) {

            synchronized (list) {
                for (int i = 1; i <= size; i++) {
                    if (i%2 != 0 ) {
                        list.add(i);
                        System.out.println("Adding thread 2 odd : " + i);
                        list.notify();
                    } else {
                        try {
//                            System.out.println("Waiting consumer");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
                break;

            }
        }
    }
}
