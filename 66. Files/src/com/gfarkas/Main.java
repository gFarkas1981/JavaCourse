package com.gfarkas;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("megrendelok.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            PrintWriter printWriter = new PrintWriter(new FileWriter("out.txt"));

            String row = bufferedReader.readLine();

            while (row != null) {

                if (row.startsWith("Név")) {

                    String[] name = row.split(" ");
                    System.out.print(name[1].substring(0, 1).toUpperCase() + name[1].substring(1).toLowerCase());
                    System.out.print(" ");
                    System.out.println(name[2].substring(0, 1).toUpperCase() + name[2].substring(1).toLowerCase());

                    printWriter.print(name[1].substring(0, 1).toUpperCase() + name[1].substring(1).toLowerCase());
                    printWriter.print(" ");
                    printWriter.println(name[2].substring(0, 1).toUpperCase() + name[2].substring(1).toLowerCase());

                }

                row = bufferedReader.readLine();

            }

            bufferedReader.close();
            printWriter.close();


        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e);

        } catch (IOException e) {

            System.out.println("File cannot be read: " + e);

        }

    }
}
