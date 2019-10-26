package com.gfarkas;

public class Node {

    private int numberOfNode;
    private String symbol;
    private int value;


    public Node(int numberOfNode, String symbol, int value) {
        this.numberOfNode = numberOfNode;
        this.symbol = symbol;
        this.value = value;
    }

    public int getNumberOfNode() {
        return numberOfNode;
    }

    public void setNumberOfNode(int numberOfNode) {
        this.numberOfNode = numberOfNode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
