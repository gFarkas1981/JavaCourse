package com.gfarkas;

public class Main {

    public static void main(String[] args) {

        Engine s63 = new Engine("S63", 8,560, 681, 4395);


        Wheel[] wheels = new Wheel[4];
        wheels[0] = new Wheel("195/60R14");
        wheels[1] = new Wheel("195/55R14");
        wheels[2] = new Wheel("195/60R14");
        wheels[3] = new Wheel("195/60R14");


        Car bmw = new Car("BMW", s63, 1945, wheels);

        wheels[0] = new Wheel("dfgd");

        System.out.println(bmw);

    }
}
