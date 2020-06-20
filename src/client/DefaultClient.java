package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Hamza Ouni
 */
public class DefaultClient {

    public static void main(String[] args) {

        try {
            System.out.println("Je me connecte au serveur...");
            Socket socket  = new Socket("localhost",1234);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Saisie un nombre...");
            int nb = scanner.nextInt();
            System.out.println("J'envoie le nombre " + nb + "au serveur") ;
            os.write(nb);
            System.out.println("j'attend la réponse du serveur...");
            int res = is.read();
            System.out.println("réponse du serveur est :" + res );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
