package threads.chat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ChatServer {

    Map<Socket, DataOutputStream> map = new HashMap<>();

    public static void main(String[] args) {
        new ChatServer().runServer();
    }

    private synchronized void broadcastToClients(String message){
        for (Map.Entry<Socket,DataOutputStream> entry:map.entrySet()) {
            try {
                entry.getValue().writeBytes(message);
                entry.getValue().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            Socket socket = serverSocket.accept(); // blokerer

            System.out.println("Forbundet til Klient");
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
