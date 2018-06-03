package com.example.javapractise.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {

        findLongestSubString("javaconceptoftheday");
    }

    //non repeat longest sub string.
    static void findLongestSubString(String s) {

        int longestSize = 0;
        String longestStr = "";

        char[] c = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i =0; i<s.length(); i++) {

            System.out.println(" processing " + c[i]);
            if (!map.containsKey(c[i])) {
                map.put(c[i], i);
            } else {
                System.out.println("previously at " + i);
                System.out.println("already present " + c[i]);
                i = map.get(c[i]);
                System.out.println(" now at " + i);
                map.clear();
            }
            if (map.size() > longestSize) {
                longestSize = map.size();
                longestStr = map.keySet().toString();

            }
        }

        System.out.println("Longest string " + longestStr + " size " + longestSize);
    }
}
