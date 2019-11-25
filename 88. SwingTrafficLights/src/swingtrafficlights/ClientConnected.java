package swingtrafficlights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnected implements Runnable {

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public ClientConnected(Socket socket) {

    }

    @Override
    public void run() {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            printWriter = new PrintWriter(socket.getOutputStream());

            String userName = bufferedReader.readLine();
            System.out.println(userName + " has connected!");

            TrafficLightModel model = new TrafficLightModel(true, false, false, true, false, false, true, false, false, true, false, false);

            new MainWindow().setVisible(true);

            String message;


            do {

                message = bufferedReader.readLine();
                System.out.println(userName + ": " + message);

                if (message.equalsIgnoreCase("TrafficLight1")) {

                    TrafficLightRunner.isStopped = !TrafficLightRunner.isStopped;
                    System.out.println(TrafficLightRunner.isStopped ? "Traffic Light 1 has stopped! " : "Traffic Light 1 has resumed! ");

                } else if (message.equalsIgnoreCase("TrafficLight2")) {


                } else if (message.equalsIgnoreCase("TrafficLight3")) {


                } else if (message.equalsIgnoreCase("TrafficLight4")) {


                }


            } while (!message.equalsIgnoreCase("exit"));

        } catch (IOException e) {

            System.out.println("Network error");

        }

    }

}