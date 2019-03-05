package threads.chat;

import java.net.Socket;

public class ClientHandler implements Runnable {


    Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        // lyt til klient
        // opdatér alle andre klienter, når denne klient har sagt noget
        // og bliv ved med det!
    }
}
