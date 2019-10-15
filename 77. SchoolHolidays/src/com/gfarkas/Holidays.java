package com.gfarkas;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class Holidays {

    public Holidays(String year, String month, String day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(year));
        cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
        Holiday h0 = new Holiday(cal, cal, "Now", "Today", "This day");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1);
        Holiday h1 = new Holiday(cal, cal, "New Year's Day", "National Holiday", "");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.MARCH, 15);
        Holiday h2 = new Holiday(cal, cal, "Revolution Day", "National Holiday", "");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.OCTOBER, 31);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(cal.get(Calendar.YEAR), Calendar.NOVEMBER, 11);
        Holiday h3 = new Holiday(cal, cal2, "Autumn Break", "School Holiday", "");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.DECEMBER, 20);
        cal2 = Calendar.getInstance();
        cal2.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 2);
        Holiday h4 = new Holiday(cal, cal2, "Winter Break", "School Holiday", "");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.APRIL, 17);
        cal2 = Calendar.getInstance();
        cal2.set(cal.get(Calendar.YEAR), Calendar.APRIL, 23);
        Holiday h5 = new Holiday(cal, cal2, "Spring Break", "School Holiday", "");

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), Calendar.JUNE, 15);
        cal2 = Calendar.getInstance();
        cal2.set(cal.get(Calendar.YEAR), Calendar.AUGUST, 31);
        Holiday h6 = new Holiday(cal, cal2, "Summer Break", "School Holiday", "");

        ArrayList<Holiday> holidays = new ArrayList<>();

        holidays.add(h1);
        holidays.add(h2);
        holidays.add(h3);
        holidays.add(h4);
        holidays.add(h5);
        holidays.add(h6);

        for (int i = 0; i < holidays.size(); i++) {



            if (holidays.get(i).getStartDate().compareTo(h0.getStartDate()) > 0) {

                long days = ChronoUnit.DAYS.between(h0.getStartDate().toInstant(), holidays.get(i).getStartDate().toInstant());

                System.out.print("The next holiday is ");
                System.out.print(holidays.get(i));
                System.out.println("\nUntil that " + days + " days left.");
                break;

            }

            if (holidays.get(i).getStartDate().compareTo(h0.getStartDate()) <= 0 &&
                    holidays.get(i).getEndDate().compareTo(h0.getStartDate()) >= 0) {

                System.out.print("You are on ");
                System.out.print(holidays.get(i));
                break;

            }

        }

    }

}
