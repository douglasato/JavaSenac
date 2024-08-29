import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaLogin extends JFrame{

    private final JLabel login = new JLabel("(Login): ");
    private final JTextField JTextFieldlogin = new JTextField();

    private final JLabel senha = new JLabel("(Senha): ");
    private final JPasswordField JPasswordFieldsenha = new JPasswordField();

    private final JButton JButtonLogin = new JButton("Login"); 
    private final JButton cadastrar = new JButton("Cadastrar");
    private final JCheckBox checkBox = new JCheckBox("Eu aceito os termos de uso");
    private final JLabel notificacao = new JLabel("Bem vindo! Faça seu login ou seu cadastro");

    public TelaLogin(){
    
    setLayout(new GridLayout(6,3,4,4));
    
    cadastrar.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                FrameNome cadastro = new FrameNome(); 
                cadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                System.out.println("algo não deu certo, erro: " + e);                    
                  }
            }
        }
    );

    add(login);
    add(notificacao); 
    add(new JLabel());
    add(JTextFieldlogin);
    add(new JLabel());
    add(new JLabel());
    add(senha);
    add(new JLabel());
    add(new JLabel());
    add(JPasswordFieldsenha);
    add(new JLabel());
    add(new JLabel());
    add(JButtonLogin);
    add(cadastrar);
    add(new JLabel());
    add(checkBox);

    setSize(550, 250);
    setVisible(true);
    }   
    public static void main(String[] args) {
        Connection conectar = MySQLConnector.conectar();
        TelaLogin login = new TelaLogin();
        login.setDefaultCloseOperation(ABORT);

    }
}
