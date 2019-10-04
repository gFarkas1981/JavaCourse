package com.gfarkas;

public class Device {

    private String name;
    private int capacity;
    private int freeSpace;
    private double randomAccessTime;

    public Device() {
    }

    public Device(String name, int capacity, int freeSpace) {
        this.name = name;
        this.capacity = capacity;
        this.freeSpace = freeSpace;
    }


    public void display() {

        System.out.println("DeviceType: " + getClass().getSimpleName() + " deviceName: "
                + getName() + " capacity: " + getCapacity() + " GB "
                + " freeSpace: " + getFreeSpace() + " GB "
                + " randomAccessTime: " + getRandomAccessTime() + "ms.");

    }

    public void write(int gb) {

        setFreeSpace(getFreeSpace() - gb);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public double getRandomAccessTime() {
        return randomAccessTime;
    }

}
