package rectangle_perimeter_area;

import java.util.Scanner;

public class RectanglePerimeterArea {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter the 'a' side of the rectangle: ");
        double a = sc.nextDouble();
        System.out.print("Please enter the 'b' side of the rectangle: ");
        double b = sc.nextDouble();
        
        double area = a * b;
        double perimeter = 2*(a + b);
        
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
        
    }
    
}
