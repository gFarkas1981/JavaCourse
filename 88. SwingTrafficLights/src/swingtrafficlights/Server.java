package swingtrafficlights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader;
            PrintWriter printWriter;

            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connection succesfull!");

            boolean trafficLight2IsActive = false;
            boolean trafficLight3IsActive = false;
            boolean trafficLight4IsActive = false;

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

                    TrafficLightRunner1.isStopped1 = !TrafficLightRunner1.isStopped1;
                    System.out.println(TrafficLightRunner1.isStopped1 ? "Traffic Light 1 has stopped! " : "Traffic Light 1 has resumed! " );

                } else if (message.equalsIgnoreCase("TrafficLight2")) {

                    TrafficLightRunner2.isStopped2 = !TrafficLightRunner2.isStopped2;
                    System.out.println(TrafficLightRunner2.isStopped2 ? "Traffic Light 2 has stopped! " : "Traffic Light 2 has resumed! " );

                }else if (message.equalsIgnoreCase("TrafficLight3")) {

                    TrafficLightRunner3.isStopped3 = !TrafficLightRunner3.isStopped3;
                    System.out.println(TrafficLightRunner3.isStopped3 ? "Traffic Light 3 has stopped! " : "Traffic Light 3 has resumed! " );

                }else if (message.equalsIgnoreCase("TrafficLight4")) {

                    TrafficLightRunner4.isStopped4 = !TrafficLightRunner4.isStopped4;
                    System.out.println(TrafficLightRunner4.isStopped4 ? "Traffic Light 4 has stopped! " : "Traffic Light 4 has resumed! " );

                }




            } while (!message.equalsIgnoreCase("exit"));

        } catch (IOException e) {

            System.out.println("Network error");

        }

    }

}
