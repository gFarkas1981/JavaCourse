package com.gfarkas;

import java.io.File;
import java.io.IOException;

class ListFiles {

    void listFiles(File path) {

        if (path.isDirectory()) {

            File[] files = path.listFiles();

            for (File f : files) {

                try {

                    System.out.println(f.getCanonicalPath());
                    listFiles(new File(f.getCanonicalPath()));

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }

}
