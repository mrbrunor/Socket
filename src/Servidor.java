
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Servidor {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        while (true) {
            Socket socket = server.accept();
            
            try(PrintWriter w = new PrintWriter(socket.getOutputStream())) {
                w.println("Recebi sua requisição");
            }
        }
    }

}