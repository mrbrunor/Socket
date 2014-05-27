
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class ChatCliente2 extends JFrame{
    
    JTextField textoEnvio;
    PrintWriter escritor;
    Socket socket;
    
    
    
    public ChatCliente2(){
        super("Chat");
        
        textoEnvio = new JTextField();
        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(null);
        Container envio = new JPanel();
        envio.setLayout(new BorderLayout());
        envio.add(BorderLayout.CENTER, textoEnvio);
        envio.add(BorderLayout.EAST, botaoEnviar);
        getContentPane().add(BorderLayout.SOUTH, envio);
        
        configurarde();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 90);
        setVisible(true);
    }
    
    private void configurarde(){
        try{ 
            socket = new Socket("127.0.0.1", 5000);
            escritor = new PrintWriter(socket.getOutputStream());
        } catch(Exception e){
            System.out.println("FUUU Cliente");
        }        
    }
    
    public static void main(String [] args) throws Exception{
        new ChatCliente2();
    }    
}
