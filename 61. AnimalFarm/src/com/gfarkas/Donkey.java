package com.gfarkas;

public class Donkey extends Puppy{

    protected boolean makacs;

    public Donkey() {
    }

    public void setMakacs(boolean makacs) {
        this.makacs = makacs;
    }

    public boolean isMakacs() {
        return makacs;
    }

    @Override
    public void display() {



            System.out.println("It's " + name + ", " + (makacs? "makacs" : "kezes") + " and " + age + " year old.");



    }

    @Override
    public void makesNoise() {
        System.out.println("iá");
    }
}
