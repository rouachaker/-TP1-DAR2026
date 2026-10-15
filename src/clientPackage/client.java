package clientPackage;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            Scanner clavier = new Scanner(System.in);

            DataInputStream entree = new DataInputStream(socket.getInputStream());
            DataOutputStream sortie = new DataOutputStream(socket.getOutputStream());

            System.out.print("Donner un entier x : ");
            int x = clavier.nextInt();

            sortie.writeInt(x);
            sortie.flush();

            int resultat = entree.readInt();
            System.out.println("Résultat reçu : " + resultat);

            socket.close();
            clavier.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
