package com.example.javapractise.array.searvh;

public class BinarySearch {

    public static boolean isPresent(int[] a, int el) {
        int first = 0;
        int last = a.length -1;
        if (Boolean.valueOf("True")){
            System.out.println("true");
        }

        int med = (first + last) / 2;
        boolean isPre = false;
        while(first <= last) {
            if (a[med] < el) {
                first = med +1;
            } else if (a[med] == el) {
                isPre = true;
                break;
            } else {
                last = med -1;
            }
            med = (first + last)/2;
        }

        return isPre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6 , 9, 11, 23, 45};

        boolean present = isPresent(arr, 19);
        System.out.println(present);


        System.out.println('a' + "a");
    }
}
