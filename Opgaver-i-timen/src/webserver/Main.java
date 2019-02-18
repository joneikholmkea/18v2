package webserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            while(true) {
                System.out.println("Afventer forbindelse...");
                Socket socket = serverSocket.accept(); // den blokerer
                System.out.println("forbindelse oprettet");
                serviceTheClient(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void serviceTheClient(Socket socket) {
        try {
            Scanner fromClient = new Scanner(socket.getInputStream());
            System.out.println("Fra client:");
            System.out.println(fromClient.nextLine());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        }catch (Exception e){

        }

    }
}
