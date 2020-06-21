package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hamza Ouni
 */
public class ServeurMultiThread extends Thread{

    private int nombreClient;
    public static void main(String[] args) {
        new ServeurMultiThread().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Démaarage du serveur");
            while(true) {
                Socket socket = ss.accept();
                ++nombreClient;
                new Conversation(socket, nombreClient).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     class Conversation extends Thread {
        private Socket socket;
        private int nombreClient;
        public Conversation(Socket socket, int nombreClient) {
            this.socket = socket;
            this.nombreClient = nombreClient;
        }
         @Override
         public void run() {
             try {
                 InputStream is = socket.getInputStream();
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr);
                 OutputStream os  =  socket.getOutputStream();
                 PrintWriter pw = new PrintWriter(os,true);
                 pw.println("Bienvenu vous etes le client nuero : " + nombreClient);
                 while(true) {
                     String req = br.readLine();
                     pw.println(req.length());
                 }


             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
}
