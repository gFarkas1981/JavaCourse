import java.time.Year;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public void setDate(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;

    }

    public String displayFormatDate(int year, int month, int day, String format) {

        if (format.equals("yymmdd")) {

            return String.valueOf(year).substring(2) + month + day;

        }

        return String.valueOf(year + month + day);

    }

    public boolean compareTo(Date date1, Date date2) {

        if ((date1.year > date2.year) ||
                (date1.year == date2.year && date1.month > date2.month) ||
                (date1.year == date2.year && date1.month == date2.month &&
                        date1.day > date2.day)) {

            return true;

        }

        return false;

    }

    public Date add(char what, int quantity) {

        Date dOut = new Date();
        dOut.year = this.year;
        dOut.month = this.month;
        dOut.day = this.day;

        if (what == 'y') {

            dOut.year = dOut.year + quantity;

        }

        if (what == 'm') {

            dOut.year += quantity / 12;
            dOut.month = dOut.month + quantity % 12;

        }

        return dOut;

    }

    public  boolean isSzokoev(int year) {

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

            return true;

        }

        return false;

    }

    public int kulonbseg(Date d) {

        return 45;


    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
