package com.example.javapractise.array;

public class Problem3 {

    public static void main(String[] args) {

        Problem3 problem1 = new Problem3();
//        System.out.println(problem1.isPresent(8));


        int[] arr = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};
//        printPairsUsingSet(arr, 8);
//        checkSubArray(arr);

        int[] arr2 = new int[]{1, 2, 1, 0, 1, 1, 0};
        findSubArr(arr2, 4);
    }


    public static void checkSubArray(int[] arr) {

        int overallSum = 0;

        for (int i =0; i< arr.length -1 ; i++) {
            overallSum = overallSum + arr[i];
        }

        for (int i =0; i< arr.length -1 ; i++) {
            int sum = arr[i];
            int[] subArray = new int[arr.length];
            subArray[0] = arr[i];
            for (int j=i+1; j< arr.length -1 ; j++) {
                sum = sum + arr[j];
                subArray[j] = arr[j];
            }
            if (sum > overallSum) {
                for (int k =0; k< subArray.length -1 ; k++) {
                    System.out.print(subArray[k]);
                }
                break;
            }
        }
    }

    public static void findSubArr(int[] arr, int l) {
        int length = 0;
        for (int i =0; i< arr.length -1 ; i++) {
            int[] subArray = new int[arr.length];
            subArray[0] = arr[i];
            int sum = arr[i];

            for (int j=i+1; j< arr.length -1 ; j++) {

                sum = sum + arr[j];
                subArray[j] = arr[j];
                if (sum >= l) {
                    break;
                }
            }

            if (length < subArray.length)
            length = subArray.length;

        }

        System.out.println("max subarray length is " + length);
    }
}
