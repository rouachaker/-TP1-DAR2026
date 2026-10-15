package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) {

        System.out.println("Je suis un client pas encore connecté...");

        try {
            Socket socket = new Socket("192.168.1.14", 5000);

            System.out.println("je suis un client connecté");

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

