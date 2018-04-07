package com.example.javapractise.multithreading.pattern1;

import java.util.LinkedList;

public class Producer implements Runnable{

    private LinkedList list;

    private int size;

    public Producer(LinkedList list, int size) {
        this.list = list;
        this.size = size;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (list) {

                if (list.size() == 0) {
                     for (int i = 0; i <= size; i++) {
                        list.add(i);
                         System.out.println("Adding : " + i);

                }
                    list.notify();

                }

                try {
                    System.out.println("waiting producer");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
