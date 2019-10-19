package com.gfarkas;

import com.gfarkas.comparators.FileComparator;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class ListFilesAndFolders {

    public void listFiles() {

        File root = new File("/java/javacourse");
        Scanner scanner = new Scanner(System.in);
        FormatString formatString = new FormatString();
        int answer;

        do {

            File[] files = root.listFiles();
            Arrays.sort(files, new FileComparator());

            for (int i = 0; i < files.length; i++) {

                File f = files[i];

                String name = formatString.makeLength50(f);

                if (f.isDirectory()) {

                    System.out.println((i + 1) + name + "\t<DIR>");

                } else {

                    System.out.println((i + 1) + name + "\t" + f.length());

                }


            }

            System.out.println("Please enter a directory number!");
            answer = scanner.nextInt();

            if (answer == 0) {

                if (root.getParentFile() != null) {

                    root = root.getParentFile();

                }

            } else if (answer > 0 && files[answer - 1].isDirectory()) {

                root = files[answer - 1];

            }

        } while (answer >= 0);

    }

}
