package com.gfarkas;

public class SSD extends Device {

    private int remainingWriteCycles;

    public SSD(int remainingWriteCycles) {
        this.remainingWriteCycles = remainingWriteCycles;
    }

    public SSD(String name, int capacity, int freeSpace, int remainingWriteCycles) {
        super(name, capacity, freeSpace);
        this.remainingWriteCycles = remainingWriteCycles;
    }

    @Override
    public double getRandomAccessTime() {

        if (remainingWriteCycles > 0) {

            return 0.1;

        }

        return -1.0;

    }

    @Override
    public void write(int gb) {

        if (remainingWriteCycles > 0 && getFreeSpace() - gb > 0) {

            remainingWriteCycles--;
            setFreeSpace(getFreeSpace() - gb);

        }


    }

    @Override
    public void display() {

        System.out.println("DeviceType: " + getClass().getSimpleName() + " deviceName: "
                + getName() + " capacity: " + this.getCapacity() + " GB "
                + " freeSpace: " + this.getFreeSpace() + " GB "
                + " randomAccessTime: " + this.getRandomAccessTime() + "ms."
                + " remainingWriteCycles: " + this.remainingWriteCycles);

    }

    public int getRemainingWriteCycles() {
        return remainingWriteCycles;
    }

    public void setRemainingWriteCycles(int remainingWriteCycles) {
        this.remainingWriteCycles = remainingWriteCycles;
    }
}
