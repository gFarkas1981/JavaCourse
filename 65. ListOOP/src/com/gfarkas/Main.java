package com.gfarkas;

public class Main {

    public static void main(String[] args) {

        MyList list = new MyList();

        list.add("alma");
        list.add("körte");
        list.add(1);

        list.remove(2);

        list.add("szilva");
        list.set(list.size() - 1, "barack");

        System.out.println(list.size());

        System.out.println("Elemei: ");
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));

        }


    }
}
