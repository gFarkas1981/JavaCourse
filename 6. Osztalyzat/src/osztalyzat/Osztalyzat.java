package osztalyzat;

import java.util.Scanner;

public class Osztalyzat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Kérem, adjon meg egy osztályzatot: ");
        int osztalyzat;
        osztalyzat = sc.nextInt();

        switch (osztalyzat) {

            case 1:
                System.out.println("elégtelen");
                break;

            case 2:
                System.out.println("elégséges");
                break;

            case 3:
                System.out.println("közepes");
                break;

            case 4:
                System.out.println("jeles");
                break;

            case 5:
                System.out.println("kitűnő");
                break;

            default:
                System.out.println("nem baj");
        }

    }

}
