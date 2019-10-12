package com.gfarkas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();


        list.add("Alma");
        list.add("Béla");
        list.add("Körte");
        list.remove(1);

        System.out.println("Size: " + list.size());

        for (Object o : list) {

            System.out.println(o);

        }

    }
}
