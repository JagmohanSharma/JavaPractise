package com.example.javapractise.multithreading.pctest;

import java.util.List;

public class EvenProducer extends Thread {

    int limit;
    private List<Integer> list;

    public EvenProducer(int limit, List<Integer> list) {
        this.limit = limit;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
