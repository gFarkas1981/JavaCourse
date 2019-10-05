package com.gfarkas;

public class Tiger extends Animal implements Predator{

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

    @Override
    public void kill(Animal prey) {

        System.out.println(this +
                "can kill " + prey);

    }

    @Override
    public String toString() {
        return "A " + age + " year old Tiger ";
    }
}
