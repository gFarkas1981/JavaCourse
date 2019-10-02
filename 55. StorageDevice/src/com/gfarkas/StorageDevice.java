package com.gfarkas;

public class StorageDevice {

    String name;
    String type;
    int capacity;
    int freeSpace;

    public StorageDevice() {
    }

    public StorageDevice(String name, String type, int capacity, int freeSpace) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.freeSpace = freeSpace;
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
