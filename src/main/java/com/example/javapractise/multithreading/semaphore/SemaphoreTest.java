package com.example.javapractise.multithreading.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreTest {

    static class PrintingJob implements Runnable {

        private PrintingQueue printingQueue;

        public PrintingJob(PrintingQueue printingQueue) {
            this.printingQueue = printingQueue;
        }

        @Override
        public void run() {

            try {
                printingQueue.printJob(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class PrintingQueue {

        private Semaphore semaphore;
        private boolean[] printAr;
        private Lock lock;

        public PrintingQueue() {
            this.semaphore = new Semaphore(3);
            this.printAr = new boolean[3];
            for (int i=0; i< 3; i++) {
                printAr[i]=true;
            }
            this.lock = new ReentrantLock();
        }

        void printJob(Object o) throws InterruptedException {
            semaphore.acquire();

            try {
                int printerNumber = getPrinter();
                System.out.println("prininting object " + o + " using printer " + printerNumber);
                Thread.currentThread().sleep(1000);
                System.out.println("finished prininting object " + o + " using printer " + printerNumber);
                release(printerNumber);
            } finally {
                semaphore.release();
            }

        }

        int getPrinter() {
            lock.lock();
            int printNum = -1;
            try {
                for (int i = 0; i < printAr.length; i++) {
                    if (printAr[i]) {
                        printAr[i] = false;
                        printNum = i;
                        break;
                    }
                }
            } finally {
                lock.unlock();
            }
            return printNum;
        }

        void release(int printnum) {
            lock.lock();
            printAr[printnum] = true;
            lock.unlock();

        }

    }


    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        PrintingQueue printerQueue = new PrintingQueue();

        for (int i =0; i< 10;i++) {
            threads[i] = new Thread(new PrintingJob(printerQueue));
        }

        for (int i =0; i< 10; i++) {
            threads[i].start();
        }
    }
}
