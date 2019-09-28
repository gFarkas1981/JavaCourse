package squareofasterisks;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class SquareOfAsterisks {

    public static void squareFromAsterisks(int size, int offset) {

        for (int i = 0; i < size; i++) {

            for (int offs = 0; offs < offset; offs++) {

                System.out.print(" ");

            }

            for (int j = 0; j < size; j++) {

                System.out.print("*");

            }

            System.out.println("");

        }

    }

    public static void towerDrawer(int squares, int lastSquareSize) {
        
        int start = lastSquareSize - (squares - 1) * 2;

        int offset = lastSquareSize;

        for (int i = start; i <= lastSquareSize; i += 2) {

            squareFromAsterisks(i,  offset);
            offset--;
        }

    }

    public static void main(String[] args) {

        towerDrawer(4, 12);

    }

}
