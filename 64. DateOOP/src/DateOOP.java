public class DateOOP {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date.isSzokoev(1981));
        Date date1 = new Date(1999,5,4);
        Date date2 = new Date(1981,9,12);


        System.out.println(date.compareTo(date1,date2));
        System.out.println(date1.add('m', 3));


    }

}
