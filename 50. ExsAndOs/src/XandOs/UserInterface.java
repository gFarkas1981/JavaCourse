package XandOs;


import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Game game = new Game();

    public void start() {

        while(!game.gameOver()){

            String command = scanner.nextLine();
            game.process(command);
            game.print();
        }

        System.out.println("Game over bitch");
        System.exit(0);

    }
}
