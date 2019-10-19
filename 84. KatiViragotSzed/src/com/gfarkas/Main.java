package com.gfarkas;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int[] flowers = {4,9,1,7,3,5,8};


        System.out.println("Kati " + Days.FRIDAY + " " + flowers[Days.FRIDAY.dayValue] + " db virágot szedett.");

    }

    enum Days {

        MONDAY(0), TUESDAY(1), WEDNESDAY(2),
        THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);

        private int dayValue;

        private Days(int dayValue) {
            this.dayValue = dayValue;
        }

        public int getDayValue() {
            return dayValue;
        }

        @Override
        public String toString() {

            switch (this) {

                case MONDAY:
                    return "hétfőn";
                case TUESDAY:
                    return "kedden";
                case WEDNESDAY:
                    return "szerdán";
                case THURSDAY:
                    return "csütörtökön";
                case FRIDAY:
                    return "pénteken";
                case SATURDAY:
                    return "szombaton";
                case SUNDAY:
                    return "vasárnap";

                default:
                    return "No such day";

            }

        }
    }
}
