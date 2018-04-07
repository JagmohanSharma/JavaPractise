package com.example.javapractise.multithreading.pattern1;

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
        switch ('w') {



        }
        while(true) {

            synchronized (list) {
                while (list.size() > 0) {
                    Object poll = list.pollLast();
                    System.out.println("Removing : " + poll);
                    list.notify();
                }

                try {
                    System.out.println("waiting consumer");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
