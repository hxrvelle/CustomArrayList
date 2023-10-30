package org.example;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1); //0
        customArrayList.add(7); //1
        customArrayList.add(333); //2
        customArrayList.add(10); //3
        customArrayList.add(109); //4
        customArrayList.add(4); //5
        customArrayList.add(222); //6
        customArrayList.add(2000); //6
        customArrayList.add(0); //6

        System.out.println("Original list: ");
        for (int i = 0; i < customArrayList.size(); i++) {
            System.out.print(customArrayList.get(i) + " ");
        }

        System.out.println("");
        System.out.println("Updated list: ");
        //customArrayList.sortDesc();

        customArrayList.quickSort();
        for (int i = 0; i < customArrayList.size(); i++) {
            System.out.print(customArrayList.get(i) + " ");
        }
    }
}