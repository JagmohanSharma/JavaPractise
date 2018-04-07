package com.example.javapractise.multithreading.pattern2;

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
                    System.out.println("Adding thread 1 even : " + 0);
                    list.add(0);
                } else {
                     for (int i = 1; i <= size; i++) {
                         if (i%2 ==0 ) {
                             list.add(i);
                             System.out.println("Adding thread 1 even : " + i);
                             list.notify();
                         } else {
                             try {
//                                 System.out.println("Waiting producer");
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
}
