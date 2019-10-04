package com.gfarkas;

public class Puppy extends Animal{

    protected String name;

    public Puppy() {
    }

    public Puppy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
