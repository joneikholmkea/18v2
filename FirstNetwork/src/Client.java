
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            System.out.println("Client starter...");
            Socket socket = new Socket("localhost", 6780);
            System.out.println("Socket er oprettet");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(99); // sender 'c'

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
