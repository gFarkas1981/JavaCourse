package com.gfarkas;

public class Order {

    private String name;
    private String email;
    private int price;
    private int pieces;

    public Order() {
    }

    public Order(String name, String email, int price, int pieces) {
        this.name = name;
        this.email = email;
        this.price = price;
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
