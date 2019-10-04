package com.gfarkas;

public class AnimalFarm {

    public static void main(String[] args) {

        Donkey d1 = new Donkey();
        d1.makacs = true;
        d1.name = "Szamár";
        d1.age = 12;
        d1.makesNoise();
        d1.display();

        Donkey d2 = new Donkey();
        d1.makacs = false;
        d1.name = "nemSzamár";
        d1.age = 3;
        d1.makesNoise();
        d1.display();

        Dog dog = new Dog();
        dog.bones = 8;
        dog.age = 4;
        dog.name = "Cuki";
        dog.makesNoise();
        dog.display();

    }
}
