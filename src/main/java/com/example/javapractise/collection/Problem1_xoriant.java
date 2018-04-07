package com.example.javapractise.collection;

public class Problem1_xoriant implements Comparable<Problem1_xoriant> {

    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int compareTo(Problem1_xoriant o) {
        String[] split = o.getVersion().split(".");
        for (int i =0; i< split.length;i++) {
//            split[]
        }
        return 0;
    }
}
