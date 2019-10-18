package com.gfarkas;

import java.io.File;

public class FormatString {

    public String makeLength50(File file) {

        File f = file;
        String outString;

        if (f.isDirectory()) {

            outString = "\t[" + f.getName() + "]";

        } else {

            outString = "\t" + f.getName();

        }




        while (outString.length() < 50) {

            outString += " ";

        }

        return outString;

    }

}
