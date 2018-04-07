package com.example.javapractise.array.sort;

public class BubbleSort {

    public static void sort(int[] arr) {

        for (int i =0; i < arr.length; i++) {
            int temp;
            for (int j = i+1; j< arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }

    }

    public static void sort2(int[] arr) {

        for (int i =0; i < arr.length - 1; i++) {
            int temp;
            for (int j = 1; j< arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] =temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {10,1,4,3,3,2,5,3,7,9,6};
        sort2(arr);
    }
}
