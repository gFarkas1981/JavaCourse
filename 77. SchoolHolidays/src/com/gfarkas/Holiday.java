package com.gfarkas;

import java.util.Calendar;

public class Holiday {

    private Calendar startDate;
    private Calendar endDate;
    private String fromDay;
    private String toDay;
    private String name;
    private String type;
    private String comment;

    public Holiday() {
    }

    public Holiday(Calendar startDate, Calendar endDate, String name, String type, String comment) {
        this.startDate = startDate;

        if (endDate.compareTo(startDate) >= 0) {

            this.endDate = endDate;

        } else {

            this.endDate = endDate;
            this.endDate.add(Calendar.YEAR, 1);

        }

        this.fromDay = getDay(startDate);
        this.toDay = getDay(endDate);
        this.name = name;
        this.type = type;
        this.comment = comment;
    }

    private String getDay(Calendar date) {

        Calendar rawDate = date;

        int dayOfWeek = rawDate.get(Calendar.DAY_OF_WEEK);

        String day = "";

        switch (dayOfWeek) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
        }

        return day;

    }

    @Override
    public String toString() {
        return "the " + name +
                " starts on " + startDate.get(Calendar.YEAR) + "."
                + (startDate.get(Calendar.MONTH) + 1) + "."
                + startDate.get(Calendar.DAY_OF_MONTH) +
                " and ends on " + endDate.get(Calendar.YEAR) + "."
                + (endDate.get(Calendar.MONTH) + 1) + "." +
                + endDate.get(Calendar.DAY_OF_MONTH) +
                ", from " + fromDay +
                ", to " + toDay +
                ", it's a " + type + ". " +
                " comment:" + comment;
    }


    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
