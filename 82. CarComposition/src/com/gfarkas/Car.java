package com.gfarkas;

import java.util.Arrays;

public class Car {

    String brand;
    Engine engine;
    int mass;
    Wheel[] wheels;

    public Car(String brand, Engine engine, int mass, Wheel[] wheels) {
        this.brand = brand;
        this.engine = engine;
        this.mass = mass;
        this.wheels = new Wheel[wheels.length];
        this.wheels[0] = new Wheel(wheels[0].getSize());
        this.wheels[1] = new Wheel(wheels[1].getSize());
        this.wheels[2] = new Wheel(wheels[2].getSize());
        this.wheels[3] = new Wheel(wheels[3].getSize());

    }

    @Override
    public String toString() {
        String wheelsText = "";

        for (Wheel wheel : wheels) {

            wheelsText += wheel + " - ";

        }

        return "Brand: " + brand +
                ", engine: " + engine +
                ", mass: " + mass + "kg" +
                ", wheels: " + wheelsText;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }
}
