package com.example.javapractise.multithreading;

public class ThreadSafety implements Runnable {

    private volatile int count;
    @Override
    public void run() {
        for (int i = 0; i<5;i++) {
            try {
                Thread.sleep(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        ThreadSafety threadSafety = new ThreadSafety();
        Thread t1 = new Thread(threadSafety);
        Thread t2 = new Thread(threadSafety);


        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadSafety.getCount());
    }
}
