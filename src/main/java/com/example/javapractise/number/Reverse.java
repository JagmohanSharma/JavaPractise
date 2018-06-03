package com.example.javapractise.number;

public class Reverse {

    public static void main(String[] args) {

        System.out.println(reverse(123));
    }

    static int reverse(int i) {

        int r =0;
        while (i != 0) {
            r = r * 10;
            r = r + i % 10;
            i = i / 10;
        }

        return r;
    }
}
