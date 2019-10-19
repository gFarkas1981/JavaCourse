package com.gfarkas.comparators;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File>{

    @Override public int compare(File o1, File o2) {

        if(o1.isDirectory() == o2.isDirectory() && o1.length() == o2.length()) {

            return o1.getName().compareToIgnoreCase(o2.getName());

        } else if (o1.isDirectory() == o2.isDirectory()) {

            if (o1.length() > o2.length()) {

                return -1;

            } else {

                return 1;

            }

        } else {

            if (o1.isDirectory()) {

                return -1;

            }

        }

        return 1;

    }

}
