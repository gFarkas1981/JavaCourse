package com.gfarkas;

import java.util.ArrayList;

public class Person {

    private String name;
    private String email;
    private ArrayList<Order> orders;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {

        orders.add(order);

    }

    public void removeOrder(Order order) {

        orders.remove(order);

    }

    public void listOrders() {

        for (Order order : orders) {

            String isCompleted = " Order is completed";

            if (!order.isCompleted) {

                isCompleted = " Order is not completed";

            }
            System.out.println("Name: " + order.person.getName() + " email: " + order.person.getEmail() + " pieces: " +
                    order.pieces + " sum: " + order.sum + isCompleted);

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
