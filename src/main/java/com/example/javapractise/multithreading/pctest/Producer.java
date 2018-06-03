package com.example.javapractise.multithreading.pctest;

import java.util.Queue;

public class Producer extends Thread {

    private Queue queue;
    private int size;

    public Producer(String name, Queue queue, int size) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    for (int i =0; i< size; i++) {
                        System.out.println("Adding in queue " + i);
                        queue.add(i);
                    }
                    queue.notifyAll();
                }

                try {
                    System.out.println("Waiting for consumer to consumer");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
