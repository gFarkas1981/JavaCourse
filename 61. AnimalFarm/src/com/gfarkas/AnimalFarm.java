package com.gfarkas;

public class AnimalFarm {

    public static void main(String[] args) {

        Donkey d1 = new Donkey();
        d1.mule = true;
        d1.name = "Little Donkey";
        d1.age = 12;

        Donkey d2 = new Donkey();
        d2.mule = false;
        d2.name = "Donkey Kong";
        d2.age = 3;

        Dog dog = new Dog();
        dog.bones = 8;
        dog.age = 4;
        dog.name = "Cuki";
        dog.kill();

        Tiger tiger = new Tiger();
        tiger.age = 11;


        Animal[] animals = new Animal[4];

        animals[0] = d1;
        animals[1] = d2;
        animals[2] = dog;
        animals[3]  = tiger;

        for (Animal animal : animals) {

            animal.makesNoise();
            animal.display();

        }



    }
}
