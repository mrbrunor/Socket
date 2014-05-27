
import java.net.Socket;
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
public class Cliente {
    
    public static void main(String [] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 5000);
        Scanner s = new Scanner(socket.getInputStream());
        System.out.println("Mensagem: " + s.nextLine());
        s.close();
    }
}
