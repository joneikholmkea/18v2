package webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    static String path = System.getProperty("user.dir");  // her får man C:/User/jon/.../18v2/
    public static void main(String[] args) {

        System.out.println(path);
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
            String request = fromClient.nextLine(); // decide what to do with this string.
            System.out.println(request);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            File file = new File("insert your value here");

                System.out.println("filen fundet");
                // Here we read a file content into a byte array:
                int length = (int) file.length();
                byte[] byteArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(byteArr);
                fileInputStream.close();

                // Sending the HTTP response header:
                dataOutputStream.writeBytes("HTTP/1.1 200 Her kommer skidtet\r\n");
                dataOutputStream.writeBytes("Content-Length: "+length+"\r\n");
                dataOutputStream.writeBytes("\r\n");  // vigtig: denne adskiller header fra indhold

                // Sending the response body:
                dataOutputStream.write(byteArr, 0, length);
                dataOutputStream.writeBytes("\n"); // check om det er nødvendigt



        }catch (Exception e){
            System.out.println(e);
        }

    }
}
