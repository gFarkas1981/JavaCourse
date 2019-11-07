package model;

import java.io.Serializable;

public class Rendeles implements Serializable {

    private int id;
    private int rendeloid;
    private int osszeg;
    private int darabszam;
    private boolean teljesitve;

    public Rendeles() {
    }

    public Rendeles(int id, int rendeloid, int osszeg, int darabszam, boolean teljesitve) {
        this.id = id;
        this.rendeloid = rendeloid;
        this.osszeg = osszeg;
        this.darabszam = darabszam;
        this.teljesitve = teljesitve;
    }

    public Rendeles(int rendeloid, int osszeg, int darabszam, boolean teljesitve) {
        this.rendeloid = rendeloid;
        this.osszeg = osszeg;
        this.darabszam = darabszam;
        this.teljesitve = teljesitve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRendeloid() {
        return rendeloid;
    }

    public void setRendeloid(int rendeloid) {
        this.rendeloid = rendeloid;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public int getDarabszam() {
        return darabszam;
    }

    public void setDarabszam(int darabszam) {
        this.darabszam = darabszam;
    }

    public boolean isTeljesitve() {
        return teljesitve;
    }

    public void setTeljesitve(boolean teljesitve) {
        this.teljesitve = teljesitve;
    }
}
