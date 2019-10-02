package com.gfarkas;

import java.util.Scanner;

public class IWontSayMoreDirtyWords {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter how many times do I have to write it: ");
        
        int times = scanner.nextInt();
        
        for (int i = 1; i <= times; i++) {
            
            System.out.println(i + ". I won't say more dirty words");
            
        }
        
    }
    
}
