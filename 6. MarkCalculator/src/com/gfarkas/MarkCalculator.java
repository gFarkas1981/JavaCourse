package com.gfarkas;

import java.util.Scanner;

public class MarkCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a mark (1-5:)");
        int mark = sc.nextInt();
        
        System.out.print("The mark is: ");
        
        switch (mark) {

            case 1:
                System.out.println("fail");
                break;

            case 2:
                System.out.println("pass");
                break;

            case 3:
                System.out.println("satisfactory");
                break;

            case 4:
                System.out.println("good");
                break;

            case 5:
                System.out.println("excellent");
                break;

            default:
                System.out.println("There's no such mark");
        }

    }

}
