package com.gfarkas;

public class PersonOrder {

    public static void main(String[] args) {

        Person p1 = new Person("Józsi", "jozsi@jzsi.hu");
        Person p2 = new Person("Béla", "bela@bela.com");

        Order o1 = new Order(p1,4, 267, true);
        Order o2 = new Order(p1,5, 189, false);
        Order o3 = new Order(p1,6, 456, true);

        Order o4 = new Order(p2,1, 967, false);
        Order o5 = new Order(p2,2, 989, false);
        Order o6 = new Order(p2,9, 956, true);

        p1.listOrders();
        System.out.println("------------------------------------------");
        p2.listOrders();
        System.out.println("----------------------------------------");
        p1.removeOrder(o1);
        p1.listOrders();

    }

}
