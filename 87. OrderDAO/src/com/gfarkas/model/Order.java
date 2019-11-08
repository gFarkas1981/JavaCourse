package com.gfarkas.model;

import java.io.Serializable;

public class Order implements Serializable {

    private int id;
    private int orderId;
    private int amount;
    private int pieces;
    private boolean complete;

    public Order() {
    }

    public Order(int id, int orderId, int amount, int pieces, boolean complete) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.pieces = pieces;
        this.complete = complete;
    }

    public Order(int orderId, int amount, int pieces, boolean complete) {
        this.orderId = orderId;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
                + orderId + "\t| " +
                + amount + "\t| " +
                + pieces + "\t| " +
                complete + "\t| ";
    }
}
