package com.gfarkas;

public class Maganhaz extends Epulet {

    private int teleknagysag;

    public Maganhaz() {
    }

    public Maganhaz(int teleknagysag) {
        this.teleknagysag = teleknagysag;
    }

    public Maganhaz(Cim cim, int alapterulet, int szobaszam, int teleknagysag) {
        super(cim, alapterulet, szobaszam);
        this.teleknagysag = teleknagysag;
    }

    @Override
    public double getIngatlanado() {

        return 2 * teleknagysag + 200 * alapterulet;

    }

    @Override
    public double getSzamitottAlapterulet() {
        return alapterulet;
    }

    @Override
    public String toString() {
        return "Ez egy magánhaz, melynek \nTeleknagysága " + teleknagysag +
                "m2,\nCíme: " + cim + "\nalapterülete " + alapterulet +
                "m2,\nSzobaszáma " + szobaszam +
                "\nSzámított alapterülete: " + getSzamitottAlapterulet() +
                "\nIngatlanadó " + getIngatlanado() + "Ft\n\n";
    }

    public int getTeleknagysag() {
        return teleknagysag;
    }

    public void setTeleknagysag(int teleknagysag) {
        this.teleknagysag = teleknagysag;
    }
}
