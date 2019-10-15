package com.gfarkas;

public class NodeList implements Node{

    private int value;
    private Node next;

    @Override
    public int getValue() {
        return value;
    }


    @Override
    public Node next() {
        return next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

}
