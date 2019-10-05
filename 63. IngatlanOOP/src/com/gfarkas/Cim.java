package com.gfarkas;

public class Cim {

    int irsz;
    String varos;
    String utcaHazsz;
    String emelet;

    public Cim() {
    }

    public Cim(int irsz, String varos, String utcaHazsz, String emelet) {
        this.irsz = irsz;
        this.varos = varos;
        this.utcaHazsz = utcaHazsz;
        this.emelet = emelet;
    }

    public int getIrsz() {
        return irsz;
    }

    public void setIrsz(int irsz) {
        this.irsz = irsz;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getUtcaHazsz() {
        return utcaHazsz;
    }

    public void setUtcaHazsz(String utcaHazsz) {
        this.utcaHazsz = utcaHazsz;
    }

    public String getEmelet() {
        return emelet;
    }

    public void setEmelet(String emelet) {
        this.emelet = emelet;
    }

    @Override
    public String toString() {
        return irsz + " " + varos + ", " + utcaHazsz + " " + emelet;
    }
}
