package com.gfarkas;

public class Dog extends Pet implements Predator{

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

    @Override
    public void kill(Animal prey) {

        System.out.println(this +
                "can kill " + prey);

    }


    @Override
    public String toString() {
        return "a " + age + " year old Dog ";
    }
}
