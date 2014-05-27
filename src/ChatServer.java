
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
        Scanner scan;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept();
                scan = new Scanner(s.getInputStream());
                System.out.println("Mensagem: " + scan.nextLine());
            }
        } catch (IOException ex) {}
    }

    public static void main(String[] args) throws Exception {
        new ChatServer();
    }

}
