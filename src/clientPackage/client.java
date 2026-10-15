
package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("===== CALCULATRICE TCP =====");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("Choisir une opération : ");
            int choix = scanner.nextInt();

            if (choix < 1 || choix > 4) {
                System.out.println("Choix invalide");
                return;
            }

            System.out.print("Donner la valeur de x : ");
            double x = scanner.nextDouble();

            InetAddress adresse = InetAddress.getByName("192.168.1.14");
            InetSocketAddress endpoint = new InetSocketAddress(adresse, 5000);

            try (Socket socket = new Socket()) {
                socket.connect(endpoint, 5000);

                DataOutputStream output =
                        new DataOutputStream(socket.getOutputStream());

                DataInputStream input =
                        new DataInputStream(socket.getInputStream());

                output.writeInt(choix);
                output.writeDouble(x);
                output.flush();

                double resultat = input.readDouble();

                System.out.println("Résultat = " + resultat);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
