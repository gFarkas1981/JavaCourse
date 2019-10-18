package com.gfarkas;

public class Engine {

    String type;
    int numberOfCylinders;
    int power;
    int torque;
    int capacity;

    public Engine(String type, int numberOfCylinders, int power, int torque, int capacity) {
        this.type = type;
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
        this.torque = torque;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine type: " + type + '\'' +
                ", numberOfCylinders=" + numberOfCylinders +
                ", power=" + power + "bhp" +
                ", torque=" + torque + "kw" +
                ", capacity=" + capacity + "ccm";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
