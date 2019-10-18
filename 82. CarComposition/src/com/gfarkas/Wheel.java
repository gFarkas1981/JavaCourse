package com.gfarkas;

public class Wheel {

    String size;

    public Wheel(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "size=" + size;
    }

    public String getSize() {
        return size;
    }

}
