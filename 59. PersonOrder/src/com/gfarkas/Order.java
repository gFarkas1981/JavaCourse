package com.gfarkas;

public class Order {

    Person person;
    int pieces;
    int sum;
    boolean isCompleted;

    public Order(Person person, int pieces, int sum, boolean isCompleted) {
        this.person = person;
        person.addOrder(this);
        this.pieces = pieces;
        this.sum = sum;
        this.isCompleted = isCompleted;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
