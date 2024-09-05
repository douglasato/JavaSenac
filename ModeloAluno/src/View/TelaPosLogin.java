package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPosLogin extends JFrame{

    JLabel JLabelboasvindas = new JLabel("Bem-vindo!");

    public TelaPosLogin(){

        setLayout(new GridLayout(6,4,5,5));
        
        add(JLabelboasvindas);
        
    
        setSize(550, 250);
        setVisible(true);
        }  

     public static void main(String[] args) {
        TelaPosLogin poslogin = new TelaPosLogin();
        poslogin.setDefaultCloseOperation(ABORT); 
     }   
}
