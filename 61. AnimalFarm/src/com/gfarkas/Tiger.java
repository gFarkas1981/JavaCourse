package com.gfarkas;

public class Tiger extends Animal {

    public Tiger() {
    }

    public Tiger(int age) {
        super(age);
    }

    @Override
    public void display() {

        System.out.println("A " + age + " year old tiger.");

    }

    @Override
    public void makesNoise() {
        System.out.println("grrrrrrr");
    }
}
