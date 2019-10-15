package com.gfarkas;

public class Main {

    public static void main(String[] args) {

        Zip zip = new Zip();
        zip.zip(new String[]{"diak.csv", "lakcimek.txt", "megrendelok.txt", "rendeles.csv"});
        zip.unZip("zipFile.zip");


    }
}
