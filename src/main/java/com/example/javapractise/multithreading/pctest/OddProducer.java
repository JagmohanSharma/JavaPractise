package com.example.javapractise.multithreading.pctest;

import java.util.List;

public class OddProducer extends Thread {

    int limit;
    private List<Integer> list;

    public OddProducer(int limit, List<Integer> list) {
        this.limit = limit;
        this.list = list;
    }

    @Override
    public void run() {
       while (true) {
           synchronized (list) {

           }
       }
    }
}
