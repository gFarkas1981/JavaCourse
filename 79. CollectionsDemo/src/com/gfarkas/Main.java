package com.gfarkas;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Béla");
        names.add("Erika");
        names.add("Gábor");
        names.add("Gábor");
        names.add("Emese");
        names.add("Levente");

        while (names.remove("Gábor"));

        for (int i = 0; i < names.size(); i++) {

            System.out.println(names.get(i));

        }


    }
}
