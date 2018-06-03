package com.example.javapractise.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class BInarySemaphore {

    static class PrinterJob implements Runnable{
        private PrinterQueue printerQueue;

        public PrinterJob(PrinterQueue printerQueue) {
            this.printerQueue = printerQueue;
        }

        @Override
        public void run() {
            try {
                printerQueue.print(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class PrinterQueue {

        private Semaphore semaphore;

        public PrinterQueue() {
            this.semaphore = new Semaphore(1);
        }

        void print(Object o) throws InterruptedException {
            semaphore.acquire();

            System.out.println("Going to print "+ Thread.currentThread().getName());

            try {
                Thread.currentThread().sleep(1000);
                System.out.println("FInished printing "+ Thread.currentThread().getName());
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        PrinterQueue printerQueue = new PrinterQueue();

        for (int i =0; i< 10;i++) {
            threads[i] = new Thread(new PrinterJob(printerQueue));
        }

        for (int i =0; i< 10; i++) {
            threads[i].start();
        }
    }
}
