package com.gfarkas;

public abstract class Epulet {

    Cim cim;
    int alapterulet;
    int szobaszam;

    public Epulet() {
    }

    public Epulet(Cim cim, int alapterulet, int szobaszam) {
        this.cim = cim;
        this.alapterulet = alapterulet;
        this.szobaszam = szobaszam;
    }

    public abstract double getIngatlanado();
    public abstract double getSzamitottAlapterulet();

    public Cim getCim() {
        return cim;
    }

    public void setCim(Cim cim) {
        this.cim = cim;
    }

    public int getAlapterulet() {
        return alapterulet;
    }

    public void setAlapterulet(int alapterulet) {
        this.alapterulet = alapterulet;
    }

    public int getSzobaszam() {
        return szobaszam;
    }

    public void setSzobaszam(int szobaszam) {
        this.szobaszam = szobaszam;
    }
}
