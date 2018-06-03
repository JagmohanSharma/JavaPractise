package com.example.javapractise.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicate {

    public static void main(String[] args) {

        getaVoid("bananas");
    }

    private static void getaVoid(String s) {

        char[] chars = s.toCharArray();
        boolean isRep = false;
        StringBuilder news = new StringBuilder(s);
        for (int i =0; i<s.length();i++) {

            for (int j=i+1; j< s.length();j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    System.out.println("deleting " + s.charAt(j)  + " " + j + " "+s + " " + news);

                    int index = news.indexOf(""+s.charAt(j));
                    System.out.println("index " + index);
                    if (index != -1)
                    news.deleteCharAt(index);
                    int indexI = news.indexOf(""+s.charAt(i));
                    if (indexI != -1)
                        news.deleteCharAt(indexI);
                }
            }
        }

        System.out.println("after " + news.toString());
    }

}
