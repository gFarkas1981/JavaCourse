package com.gfarkas;

public class Donkey extends Pet {

    protected boolean mule;

    public Donkey() {
    }

    public void setMakacs(boolean makacs) {
        this.mule = makacs;
    }

    public boolean isMakacs() {
        return mule;
    }

    @Override
    public void display() {



            System.out.println("It's " + name + ", " + (mule? "mule" : "well-mannered") + " and " + age + " year old.");



    }

    @Override
    public void makesNoise() {
        System.out.println("iá");
    }

    @Override
    public String toString() {
        return name + " a " + age + " years old " + (mule? "mule" : "well-mannered") +
                " Donkey.";
    }
}
