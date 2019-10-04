package com.gfarkas;

public class StorageDevice2 {

    public static void main(String[] args) {

        Device[] devices = new Device[4];

        devices[0] = new SSD(23);
        devices[0].setName("SSD1");
        devices[0].setCapacity(256);
        devices[0].setFreeSpace(120);

        devices[1] = new SSD(7);
        devices[1].setName("SSD2");
        devices[1].setCapacity(128);
        devices[1].setFreeSpace(20);

        devices[2] = new HDD(7200);
        devices[2].setName("HDD1");
        devices[2].setCapacity(2000);
        devices[2].setFreeSpace(1228);

        devices[3] = new HDD(5400);
        devices[3].setName("HDD2");
        devices[3].setCapacity(640);
        devices[3].setFreeSpace(121);

        for (Device device : devices) {

            device.display();

        }

        for (int i = 0; i < 10; i++) {

            devices[0].write(3);
            devices[1].write(3);

            devices[2].write(3);
            devices[3].write(3);

            for (Device device : devices) {

                device.display();

            }

            System.out.println("-----------------------------------------");

        }

    }
}
