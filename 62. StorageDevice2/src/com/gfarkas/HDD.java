package com.gfarkas;

public class HDD extends Device {

    private int rpm;

    public HDD() {}

    public HDD(int rpm) {
        this.rpm = rpm;
    }

    public HDD(String name, int capacity, int freeSpace, int rpm) {
        super(name, capacity, freeSpace);
        this.rpm = rpm;
    }

    @Override
    public double getRandomAccessTime() {

        return 5 + 0.05 + 1000 / (this.rpm / 60.0) / 2;

    }

    @Override
    public void display() {

        System.out.println("DeviceType: " + getClass().getSimpleName() + " deviceName: "
                + getName() + " capacity: " + getCapacity() + " GB "
                + " freeSpace: " + getFreeSpace() + " GB " + " rpm: " + rpm
                + " randomAccessTime: " + getRandomAccessTime() + "ms.");

    }

    @Override
    public void write(int gb) {

        if (getFreeSpace() - gb > 0) {

            setFreeSpace(getFreeSpace() - gb);

        }


    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}
