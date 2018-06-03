package com.example.javapractise.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericsEx {

    public static  <T> void testGeneric(T t) {
        System.out.println(t);
    }

    static void testUpperBounderWildCard(List<? extends Object> list) {
//upper bounded wild card example
//        list.add(2);

    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        testUpperBounderWildCard(integerList);
        List<Number> numberList = new ArrayList<>();
        testUpperBounderWildCard(numberList);

        List<? extends Object> objectList = new ArrayList<>();
        testUpperBounderWildCard(objectList);

        List<Double> doubles = new ArrayList<>();
        testUpperBounderWildCard(doubles);

        testGeneric("testString");

        //type inference
        GenericsEx.<Integer>testGeneric(3);

        //Bounded type parameters
        testBoundedType(new Test());

        List<String> strings = new ArrayList<>();
        strings.add("asdd");

        strings.add("sdsds");


        Collection<String> strings1 = new ArrayList<>();

        numberList.add(Double.valueOf(1.23));
        List<Integer> integerList1 = new ArrayList<>();

//        numberList = integerList;

        objectList = strings;
        strings1 = strings;

        Iterator<String> iterator = strings.iterator();

        System.out.println(strings.size());
        while (iterator.hasNext()) {

            String s = iterator.next();
            iterator.remove();
            System.out.println(s);

        }

        System.out.println(strings.size());


    }

    static class Test implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static <T extends Comparable<T>> void testBoundedType(T t) {

        System.out.println(t);
    }
}
