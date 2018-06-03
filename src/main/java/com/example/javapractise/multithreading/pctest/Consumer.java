package com.example.javapractise.multithreading.pctest;

import java.util.Queue;

public class Consumer extends Thread {

    private Queue<Integer> queue;
    private int size;

    public Consumer(String name, Queue queue, int size) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty() && queue.size() == size) {
                    while (!queue.isEmpty()) {
                        Integer removed =  queue.poll();
                        System.out.println("Removed from queue " + removed);

                    }
                    queue.notifyAll();
                }

                try {
                    System.out.println("Wating for producer to add");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
