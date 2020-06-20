package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hamza Ouni
 */
public class DefaultServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("J'attend la connexion... ");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            System.out.println("J'attend que le client envoie un octet...");
            int nb = is.read();
            System.out.println("j'ai recu un nombre "+ nb);
            int res = nb * 5;
            System.out.println("j'envoie la réponse...");
            os.write(res);
            //close connexion
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
