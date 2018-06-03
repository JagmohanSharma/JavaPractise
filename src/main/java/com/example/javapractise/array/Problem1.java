package com.example.javapractise.array;

import com.example.javapractise.array.sort.BubbleSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * How to Find all Pairs in Array of Integers Whose sum is Equal to a Given Number - Java Solution
 */
public class Problem1 {

    public boolean isPresent(int a) {

        int[] arr = new int[]{1, 4, 2, 5, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return true;
            }
        }

        return false;
    }

    public void printPairs(int a) {
        int[] arr = new int[]{1, 4, 3, 2, 4, 5, 7, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == a && arr[i] != arr[j]) {
                    System.out.println("pair : " + arr[i] + "," + arr[j]);
                }
            }
        }
    }

    public void printPairsSet(int a) {
        int[] arr = new int[]{1, 4, 3, 2, 4, 5, 7, 4, 1, 7};
        Set<Integer> set = new HashSet(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int target = a - arr[i];
            if (set.contains(target)) {
                System.out.println("pair : " + arr[i] + "," + target);
            } else {
//                System.out.println("adding " + target);
                set.add(arr[i]);
            }
        }
    }

    public static void printPairsSort(int a) {
        int[] arr = new int[]{1, 4, 3, 2, 4, 5, 7, 4, 1, 7};
        BubbleSort.sort(arr);

        int low = 0;
        int up = arr.length - 1;

        while (low < up) {
            int sum = arr[low] + arr[up];

            if (sum == a) {
                System.out.println("pair: " + arr[low] + "," + arr[up]);
                low++;
                up--;
            } else if (sum < a) {
                low++;
            } else if (sum > a) {
                up--;
            }
            
        }
    }


    public static void main(String[] args) {

        Problem1 problem1 = new Problem1();
//        System.out.println(problem1.isPresent(8));
        problem1.printPairs(8);

        
        printPairsSort(8);

        int[] arr = new int[]{1, 4, 3, 2, 4, 5, 7, 4, 1, 7};
//        printPairsUsingSet(arr, 8);

    }

    public static void printPairsUsingSet(int[] numbers, int n) {
        if (numbers.length < 2) {
            return;
        }
        Set set = new HashSet(numbers.length);
        for (int value : numbers) {
            int target = n - value; // if target number is not in set then add
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }

}