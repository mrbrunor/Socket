
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class ChatServer {

    public ChatServer() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept();
                new Thread(new EscutaCliente(s)).start();
            }
        } catch (IOException ex) {
        }
    }

    private class EscutaCliente implements Runnable {

        Scanner leitor;

        public EscutaCliente(Socket socket) {
            try {
                leitor = new Scanner(socket.getInputStream());
            } catch (Exception e) {}
        }

        @Override
        public void run() {
            try {
                String mensagem;
                while ((mensagem = leitor.nextLine()) != null) {
                    System.out.println("Recebeu: " + mensagem);
                }
            } catch (Exception ee) {}
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatServer();
    }

}
