package com.gfarkas;

public class IngatlanOOP {

    public static void main(String[] args) {

        Epulet e1 = new TarsashaziLakas(5, 3);
        e1.setAlapterulet(46);
        Cim cim1 = new Cim(1111, "Budapest" , "Kecske utca 8.","");
        e1.setCim(cim1);
        e1.setSzobaszam(2);

        Epulet e2 = new TarsashaziLakas(10, 6);
        e2.setAlapterulet(92);
        Cim cim2 = new Cim(2031, "Érd" , "Csónak utca 3.","3A");
        e2.setCim(cim2);
        e2.setSzobaszam(4);

        Epulet e3 = new Maganhaz(800);
        e3.setAlapterulet(100);
        Cim cim3 = new Cim(8000, "Szeged" , "Fecske utca 28.","");
        e3.setCim(cim3);
        e3.setSzobaszam(10);

        Epulet e4 = new Maganhaz(100);
        e4.setAlapterulet(30);
        Cim cim4 = new Cim(4000, "NincsVáros" , "Lepke utca 328.","32/B");
        e4.setCim(cim4);
        e4.setSzobaszam(1);

        Epulet[] epulets = new Epulet[4];
        epulets[0] = e1;
        epulets[1] = e2;
        epulets[2] = e3;
        epulets[3] = e4;

        for (Epulet epulet : epulets) {

            System.out.println(epulet);

        }

    }
}
