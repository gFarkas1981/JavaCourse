package com.gfarkas;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File path = new File("c:/java/javacourse");

        ListFiles listFiles = new ListFiles();
        listFiles.listFiles(path);

    }

}
