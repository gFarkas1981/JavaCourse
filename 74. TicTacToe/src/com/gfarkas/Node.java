package com.gfarkas;

public class Node {

    private int numberOfNode;
    private String symbol;

    public Node() {
    }

    public Node(int numberOfNode) {
        this.numberOfNode = numberOfNode;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public Node(int numberOfNode, String symbol) {
        this.numberOfNode = numberOfNode;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
