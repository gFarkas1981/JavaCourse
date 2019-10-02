package com.gfarkas;

import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        String unit = "";
        
        while (!( unit.equals("foot") || unit.equals("mile") || unit.equals("yard") || unit.equals("inch") || unit.equals("line") )) {
           
            System.out.println("Please enter the unit: (foot/mile/yard/inch/line");
            unit = scanner.nextLine().toLowerCase();
            
        }
        
        double value;
        
        try {
        
            System.out.print("Please enter a value: ");
            value = scanner.nextDouble();
            
        } catch (Exception e) {
            
            System.out.println("It was not a value, I presume!");
            System.out.println("Default value (1) was selected");
            value = 1.0;
            
        }
        
        if (unit.equals("foot")) {
            
            unit = "feets";
            
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 5280.0) + " miles.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 3.0) + " yards.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 12) + " inches.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 143.997732) + " lines.");
            
        } else if (unit.equals("mile")) {
            
            unit = "miles";
            
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 5280) + " feet.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 1760) + " yards.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 63360) + " inches.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 760320) + " lines.");
            
        } else if (unit.equals("yard")) {
            
            unit = "yards";
            
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 3) + " feet.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 1760) + " miles.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 63360) + " inches.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 760320) + " lines.");
            
        } else if (unit.equals("inch")) {
            
            unit = "inches";
            
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 3) + " feet.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 1760) + " miles.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 63360) + " yards.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value * 12) + " lines.");
            
        } else if (unit.equals("line")) {
            
            unit = "lines";
            
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 1_000_000.0 * 6944.44) + " feet.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 1_000_000_000.0 * 1315.24) + " miles.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 100_000.0 * 231.48) + " yards.");
            System.out.println(value + " " + unit + " equals to " + String.format("%.8f", value / 12.0) + " inches.");
            
        }
        
        
    }
    
}
