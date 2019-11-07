package com.gfarkas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name!");
        String name = scanner.nextLine();
        System.out.println("Please enter an email address!");
        String email = scanner.nextLine();


        DB db = new DB();
        System.out.println(db.newCustomer(name, email));
        Customer[] customers = db.listCustomers();

        for (Customer customer : customers) {

            System.out.println("Name: " + customer.getName() + ", email: " + customer.getEmail());

        }

    }
}
