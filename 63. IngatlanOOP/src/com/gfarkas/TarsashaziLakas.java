package com.gfarkas;

import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;

public class TarsashaziLakas extends Epulet{

    private int erkelyMeret;
    private int szomszedokSzama;

    public TarsashaziLakas() {
    }

    public TarsashaziLakas(int erkelyMeret, int szomszedokSzama) {
        this.erkelyMeret = erkelyMeret;
        this.szomszedokSzama = szomszedokSzama;
    }

    public TarsashaziLakas(Cim cim, int alapterulet, int szobaszam, int erkelyMeret, int szomszedokSzama) {
        super(cim, alapterulet, szobaszam);
        this.erkelyMeret = erkelyMeret;
        this.szomszedokSzama = szomszedokSzama;
    }

    @Override
    public double getIngatlanado() {
        return 300 * alapterulet;
    }

    @Override
    public double getSzamitottAlapterulet() {
        return alapterulet + erkelyMeret / 2;
    }

    @Override
    public String toString() {
        return "Ez egy társasházi lakás, melynek \n" +
                "Erkély mérete " + erkelyMeret +
                "m2, \nSzomszédok száma " + szomszedokSzama +
                ", \nCíme: " + cim +
                ", \nAlapterülete " + alapterulet +
                "m2, \nSzobaszám " + szobaszam +
                " \nSzámított alapterület: " + getSzamitottAlapterulet() +
                "m2, \nIngatlanadó: " + getIngatlanado() + "Ft.\n\n";
    }


    public int getErkelyMeret() {
        return erkelyMeret;
    }

    public void setErkelyMeret(int erkelyMeret) {
        this.erkelyMeret = erkelyMeret;
    }

    public int getSzomszedokSzama() {
        return szomszedokSzama;
    }

    public void setSzomszedokSzama(int szomszedokSzama) {
        this.szomszedokSzama = szomszedokSzama;
    }
}
