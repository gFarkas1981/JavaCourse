package com.gfarkas;

import java.util.Scanner;

public class Cuboid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter the length of a cuboid: ");
        double length = scanner.nextDouble();
        
        System.out.print("Please enter the breadhth of a cuboid: ");
        double breadth = scanner.nextDouble();
        
        System.out.print("Please enter the height of a cuboid: ");
        double height = scanner.nextDouble();
        
        System.out.println
        ("The cuboid's surface area: " +
                (2 * ((length * height) + (length * breadth) + (breadth * height))));
        
        System.out.println("The cuboid's volume: " + (length * breadth * height));
    }
    
}
