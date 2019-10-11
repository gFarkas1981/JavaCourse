package com.gfarkas;

import java.util.Scanner;

class NextStep {

    int[] nextStep(String actualPlayer) {

        int row = -1;
        int column = -1;
        String s1 = "";
        String s2 = "";

        while (s1.equals("") || s2.equals("")) {

            String step = stepScanner(actualPlayer);

            if (step.length() < 1 || step.length() > 2) {

                s1 = "";

                System.out.println("One character and one integer, please!");
                new HorizontalLine();

            } else {

                s1 = step.substring(0, 1);
                s2 = step.substring(1);

                switch (s1.toLowerCase()) {

                    case "a":
                        row = 0;
                        break;

                    case "b":
                        row = 1;
                        break;

                    case "c":
                        row = 2;
                        break;

                    default:
                        s1 = "";
                        new HorizontalLine();
                        System.out.println("Wrong row character!");
                        new HorizontalLine();

                }

                try {

                    column = Integer.parseInt(s2);

                } catch (Exception e) {

                    s2 = "";
                    new HorizontalLine();

                    System.out.println("Wrong column number!");
                    new HorizontalLine();
                }

                if (!s1.equals("") && !s2.equals("") && (column < 1 || column > 3)) {

                    s2 = "";
                    new HorizontalLine();
                    System.out.println("Wrong column number!");
                    new HorizontalLine();

                }

            }

        }

        return new int[]{row, column};

    }

    protected String stepScanner(String actualPlayer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(actualPlayer + " please enter the next step: (ie.: A2)");

        return scanner.nextLine();

    }

}
