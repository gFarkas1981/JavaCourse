package com.gfarkas;

public class StorageDeviceOOP {

    public static void main(String[] args) {

        StorageDevice[] storageDevices = new StorageDevice[20];

        storageDevices[0] = new StorageDevice("Maxtor", "HDD", 640000, 300000);
        storageDevices[1] = new StorageDevice("Seagate", "HDD" , 500000,10000);
        storageDevices[2] = new StorageDevice("Fujitsu", "HDD",320000, 200000);
        storageDevices[3] = new StorageDevice("Siemens", "HDD",256000, 120000);
        storageDevices[4] = new StorageDevice("Kamu-digital","HDD", 128000, 30000);
        storageDevices[5] = new StorageDevice("Maxtor", "CD", 700,300);
        storageDevices[6] = new StorageDevice("Seagate", "CD",700, 0);
        storageDevices[7] = new StorageDevice("Fujitsu", "CD",700, 200);
        storageDevices[8] = new StorageDevice("Siemens", "CD", 700, 120);
        storageDevices[9] = new StorageDevice("Kamu-digital", "CD", 650, 30);
        storageDevices[10] = new StorageDevice("Maxtor", "DVD", 4600, 300);
        storageDevices[11] = new StorageDevice("Seagate", "DVD" , 4600,10);
        storageDevices[12] = new StorageDevice("Fujitsu", "DVD",4600, 200);
        storageDevices[13] = new StorageDevice("Siemens", "DVD",4600, 120);
        storageDevices[14] = new StorageDevice("Kamu-digital","DVD", 4600, 30);
        storageDevices[15] = new StorageDevice("Maxtor", "SSD", 320000,300);
        storageDevices[16] = new StorageDevice("Seagate", "SSD",700000, 0);
        storageDevices[17] = new StorageDevice("Fujitsu", "SSD",512000, 200000);
        storageDevices[18] = new StorageDevice("Siemens", "SSD", 640000, 120000);
        storageDevices[19] = new StorageDevice("Kamu-digital", "SSD", 1280000, 30000);

        for (StorageDevice element: storageDevices) {

            System.out.println("Name:" + element.name + " | Type:" + element.type + " | Free space: " + element.freeSpace + "MB out of " + element.capacity + "MB.");

        }

    }
}
