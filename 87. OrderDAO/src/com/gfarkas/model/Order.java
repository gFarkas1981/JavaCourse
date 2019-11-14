package com.gfarkas.model;

import java.io.Serializable;

public class Order implements Serializable {

    private int id;
    private int customerId;
    private int amount;
    private int pieces;
    private boolean complete;

    public Order() {
    }

    public Order(int id, int customerId, int amount, int pieces, boolean complete) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.pieces = pieces;
        this.complete = complete;
    }

    public Order(int customerId, int amount, int pieces, boolean complete) {
        this.customerId = customerId;
        this.amount = amount;
        this.pieces = pieces;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "|\t"+ id + "\t| " +
                +customerId + "\t| " +
                + amount + "\t| " +
                + pieces + "\t| " +
                complete + "\t| ";
    }
}
