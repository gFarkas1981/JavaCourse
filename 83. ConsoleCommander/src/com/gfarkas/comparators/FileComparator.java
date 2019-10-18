package com.gfarkas.comparators;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File>{

    @Override public int compare(File o1, File o2) {

        boolean isFirstDirectory = o1.isDirectory();
        boolean isSecondDirectory = o2.isDirectory();

        if(!isFirstDirectory && !isSecondDirectory) {

            if (o1.length() > o2.length()) {

                return -1;

            } else {

                return 1;


            }

        } else if (isFirstDirectory && !isSecondDirectory){
            return -1;
        } else if(isSecondDirectory && !isFirstDirectory) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }


    }

}
