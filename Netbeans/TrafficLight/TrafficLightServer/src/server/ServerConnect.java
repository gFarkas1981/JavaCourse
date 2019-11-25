package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnect {
    
    private String message;

    public ServerConnect() {
        
        try {

            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            
        } catch (IOException e) {

            System.out.println("Network error");

        }

    }

}