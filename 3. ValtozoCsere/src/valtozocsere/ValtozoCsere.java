/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valtozocsere;

/**
 *
 * @author info
 */
public class ValtozoCsere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a = 3;
        int b = 7;
        
        b += a;
        a = b - a;
        b -= a;
        
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        
    }
    
}
