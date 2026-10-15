package serverPackage;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(1234);
            System.out.println("Serveur en attente de connexion...");

            Socket socket = serveur.accept();
            System.out.println("Client connecté !");

            DataInputStream entree = new DataInputStream(socket.getInputStream());
            DataOutputStream sortie = new DataOutputStream(socket.getOutputStream());

            int x = entree.readInt();
            System.out.println("Nombre reçu : " + x);

            int resultat = x * 5;
            sortie.writeInt(resultat);
            sortie.flush();

            System.out.println("Résultat envoyé : " + resultat);

            socket.close();
            serveur.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
