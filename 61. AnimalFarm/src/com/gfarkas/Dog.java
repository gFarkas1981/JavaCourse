package com.gfarkas;

public class Dog extends Puppy{

    protected int bones;

    public Dog() {
    }

    @Override
    public void display() {

        System.out.println("It's " + name + " and " + age + " year old and " +
                "has " + bones + " bones.");

    }

    @Override
    public void makesNoise() {
        System.out.println("vau vau");
    }
}
