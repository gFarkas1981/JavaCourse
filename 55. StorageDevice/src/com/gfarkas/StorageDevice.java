package com.gfarkas;

public class StorageDevice {

    private String name;
    private String type;
    private int capacity;
    private int freeSpace;

    public StorageDevice() {
    }

    public StorageDevice(String name, String type, int capacity, int freeSpace) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.freeSpace = freeSpace;
    }

    public void display() {

        System.out.println("Name:" + this.getName() +
                " | Type:" + this.getType() +
                " | Free space: " + this.getFreeSpace() +
                "MB out of " + this.getCapacity() + "MB.");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


}
