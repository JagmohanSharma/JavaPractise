package com.example.javapractise.string;

public class Palindrom {

    public static void main(String[] args) {

        System.out.println(isPalindrom("jaggs"));

        reverse("sfassaf");

        System.out.println("recusion " + recusion("jags"));
    }

    static boolean isPalindrom(String s) {

        String r = "";

        char[] c = s.toCharArray();

        for (int i = c.length-1; i>=0; i--) {
            r = r + c[i];
        }

        System.out.println("reversed" + r);

        if (r.equals(s)) {
            return true;
        }
        return false;
    }

    static void reverse(String s) {
        int first =0;
        int last = s.length() -1 ;
        int med = (first + last)/2;
        int i;
        for (i = first; i <= med; i++) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            }
            else
                break;
        }

        if (i == med + 1) {
            System.out.println("palindrom");
        } else
            System.out.println("not");
    }

    static String recusion(String s) {

        return recusion(s.substring(1)) + s.charAt(0);
    }
}
