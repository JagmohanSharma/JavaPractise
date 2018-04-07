package com.example.javapractise.array;

import java.util.HashMap;
import java.util.Map;

/**
 * How to find repeated numbers in an array if it contains multiple duplicates?
 */
public class Problem2 {


   public void findDuplicateInString(String s) {
       Map<Character, Integer> map = new HashMap();

       char arr[] = s.toCharArray();

       for (char c : arr) {

           if (map.containsKey(c)) {
               Integer i = map.get(c);
               map.put(c, ++i);
           } else {

           }
       }
   }
    public static void main(String[] args) {

    }
}