package com.gfarkas;

public class Order {

    int customerID;
    int amount;
    int pieces;

    public Order(int customerID, int amount, int pieces) {
        this.customerID = customerID;
        this.amount = amount;
        this.pieces = pieces;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAmount() {
        return amount;
    }

    public int getPieces() {
        return pieces;
    }

}
