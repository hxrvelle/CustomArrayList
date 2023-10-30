package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList<>();
//        customArrayList.add(1);
//        customArrayList.add(7);
//        customArrayList.add(333);
//        customArrayList.add(10);
//        customArrayList.add(109);
//        customArrayList.add(4);
//        customArrayList.add(222);
//        customArrayList.add(2000);
//        customArrayList.add(0);
//
//        for (int i = 0; i < customArrayList.size(); i++) {
//            System.out.print(customArrayList.get(i) + " ");
//        }
//
//        System.out.println();
//
//        customArrayList.quickSort(Comparator.naturalOrder());
//        for (int i = 0; i < customArrayList.size(); i++) {
//            System.out.print(customArrayList.get(i) + " ");
//        }
        //customArrayList.add(null);
        customArrayList.quickSort(Comparator.naturalOrder());
    }
}