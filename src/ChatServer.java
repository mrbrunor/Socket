
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    List<PrintWriter> escritores = new ArrayList<>();

    public ChatServer() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept();
                new Thread(new EscutaCliente(s)).start();
                PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                escritores.add(printWriter);
            }
        } catch (IOException ex) {
        }
    }

    private class EscutaCliente implements Runnable {

        Scanner leitor;

        public EscutaCliente(Socket socket) {
            try {
                leitor = new Scanner(socket.getInputStream());
            } catch (Exception e) {
            }
        }

        private void encaminharParaTodos(String mensagem) {
            for (PrintWriter printWriter : escritores) {
                try {
                    printWriter.println(mensagem);
                    printWriter.flush();
                } catch (Exception e) {}
            }
        }

        @Override
        public void run() {
            try {
                String mensagem;
                while ((mensagem = leitor.nextLine()) != null) {
                    encaminharParaTodos(mensagem);
                }
            } catch (Exception ee) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatServer();
    }

}
