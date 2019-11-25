package swingtrafficlights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;


    public void openSocket() {

        try {


            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Waiting for client connection...");
            socket = serverSocket.accept();
            System.out.println("Client connection succesfull!");


        } catch (IOException e) {

            System.out.println("Network error");

        }


    }

}
