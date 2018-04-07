package com.example.javapractise.multithreading;

public class BankDeposit {

    private int amount = 1000;

    private synchronized void deposit(int amount) {
        System.out.println("current amount in deposit " + this.amount);
        this.amount = this.amount + amount;
        System.out.println("deposting " + amount + " new amount is " + this.amount);
        notify();
    }

    private synchronized void withdraw(int amount) {

        if (this.amount < amount) {
            try {
                System.out.println("not enough amount to withdraw.. waiting to deposit...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.amount = this.amount - amount;
        System.out.println("amount deducted : " + amount + " Now it has " + this.amount);
    }


    public static void main(String[] args) {
        BankDeposit bankDeposit = new BankDeposit();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                bankDeposit.withdraw(2000);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                bankDeposit.deposit(3000);
            }
        };

        t1.start();
        t2.start();
    }
}
