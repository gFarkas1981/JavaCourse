package com.gfarkas;

public abstract class Device {

    private String name;
    private int capacity;
    private int freeSpace;

    Device() {
    }

    Device(String name, int capacity, int freeSpace) {
        this.name = name;
        this.capacity = capacity;
        this.freeSpace = freeSpace;
    }


    public abstract void display();
    public abstract void write(int gb);
    public abstract double getRandomAccessTime();

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    int getFreeSpace() {
        return freeSpace;
    }

    void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

}
