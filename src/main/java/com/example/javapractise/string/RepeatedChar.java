package com.example.javapractise.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatedChar {

    public static void main(String[] args) {

        firstRepUsingMap("wsatsddsa");
        firstRepIterative("wsatsddsa");



    }

    static void firstRepUsingMap(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i =0; i< s.length();i++) {

            if (map.containsKey(s.charAt(i))) {
                Integer count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (Character c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.println("first repeat char "+ c + map.get(c));
                break;
            }
        }

        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                System.out.println("first non repeat char "+ c + map.get(c));
                break;
            }
        }
    }

    static void firstRepIterative(String s) {

        int count = 1;

        char[] c = s.toCharArray();
        for (int i =0; i< c.length; i++) {

            for (int j=i+1; j< c.length; j++) {
                if (c[i] == c[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("First non repeat " + c[i] + " " + count);
                break;
            }
        }
    }
}
