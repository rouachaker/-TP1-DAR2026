
package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {

        try {
            InetAddress adresse = InetAddress.getByName("192.168.1.14");
            InetSocketAddress endpoint = new InetSocketAddress(adresse, 5000);

            try (ServerSocket serverSocket = new ServerSocket()) {

                serverSocket.bind(endpoint);
                System.out.println("Serveur en attente de connexion...");

                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    System.out.println("Un client est connecté");

                    int choix = input.readInt();
                    double x = input.readDouble();
                    double resultat = 0;

                    switch (choix) {
                        case 1:
                            resultat = x + 5;
                            break;
                        case 2:
                            resultat = x - 5;
                            break;
                        case 3:
                            resultat = x * 5;
                            break;
                        case 4:
                            resultat = x / 5;
                            break;
                        default:
                            System.out.println("Opération invalide");
                    }

                    output.writeDouble(resultat);
                    output.flush();

                    System.out.println("Résultat envoyé : " + resultat);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
