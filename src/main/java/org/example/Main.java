package org.example;

import org.example.datastructures.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Object> objects = new CustomArrayList<>();

        for (int i = 0; i < 1000; i++) {
            objects.add(0, new Object());
            System.out.println(objects.get(0));
        }
    }
}
