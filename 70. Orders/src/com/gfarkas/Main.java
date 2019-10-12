package com.gfarkas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader("rendeles.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String row = bufferedReader.readLine();

            while (row != null) {

                if (!row.startsWith("Név;")) {

                    String[] oneOrder = row.split(";");
                    Order order = new Order();
                    order.setName(oneOrder[0]);
                    order.setEmail(oneOrder[1]);
                    order.setPrice(Integer.parseInt(oneOrder[2]));
                    order.setPieces(Integer.parseInt(oneOrder[3]));

                    orders.add(order);

                }

                row = bufferedReader.readLine();

            }

            bufferedReader.close();


        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e);

        } catch (IOException e) {

            System.out.println("File cannot be read: " + e);

        }

        int sum = 0;

        for (Order order : orders) {

            if (order.getPrice() * order.getPieces() > 50000) {

                System.out.println(order);
                sum += order.getPrice() * order.getPieces();

            }

        }

        System.out.println("sum: " + sum);

    }

}
