package com.example.javapractise.multithreading.pctest;

import java.util.LinkedList;
import java.util.Queue;

public class Pctest {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList();

        Producer producer = new Producer("Producer", queue, 10);
        Consumer consumer = new Consumer("Consumer", queue, 10);

        producer.start();
        consumer.start();

    }
}
