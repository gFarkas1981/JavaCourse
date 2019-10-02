package com.gfarkas;

import java.util.Scanner;

public class Sphere {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the radius of the sphere: ");
        double radius = scanner.nextDouble();
        
        System.out.println("The surface of the sphere is " + (4 * Math.PI * Math.pow(radius, 2)));
        System.out.println("The volume of the sphere is " + (((double) 4 / 3) * (Math.PI * Math.pow(radius, 3))));
        System.out.println(Math.pow(radius, 3));
    }

}
