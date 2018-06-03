package com.example.javapractise.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExp {

    static void testSerial() throws IOException, ClassNotFoundException {

        POJO pojo = new POJO("name", "lastname", 12, 2333);
        File file = new File("/Users/sharmaja/sharmaja_cobalt_codebase/sharmaja_cobalt_codebase/javapractise/src/main/resources/test");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(pojo);
        objectOutputStream.close();
        System.out.println("Before de - serial" + pojo.getAge() + pojo.getIncome() + pojo.getLastName() + pojo.getName());

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        POJO pojo1 = (POJO) objectInputStream.readObject();

        List<String> list = new ArrayList<>();
        list.add(new String("list string"));

        List<Object> objectList = new ArrayList<>();


        List<? extends Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Number number = new Integer(3);
        numberList.add(null);
        numberList = integerList;

        objectList.add("");
        objectList.add(9);

        for (Object o: objectList) {
            System.out.println("objectList" + o);
        }

        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println(pojo == pojo1);

        objectInputStream.close();
        System.out.println("After de - serial" + pojo1.getAge() + pojo1.getIncome() + pojo1.getLastName() + pojo1.getName());
    }

    public static void main(String[] args) {
        try {
            testSerial();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     static class ParentPOJO {

        String parentname;

        public String getParentname() {
            return parentname;
        }

        public void setParentname(String parentname) {
            this.parentname = parentname;
        }
    }

     static class POJO extends ParentPOJO implements Serializable {

        String name;
        transient String lastName;
        int age;
        Integer income;

        public POJO(String name, String lastName, int age, Integer income) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.income = income;
        }

        /*private void readObject(ObjectInputStream ois) {
            try {
                String lastname = (String)ois.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                ois.defaultReadObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }*/

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Integer getIncome() {
            return income;
        }

        public void setIncome(Integer income) {
            this.income = income;
        }

    }
}