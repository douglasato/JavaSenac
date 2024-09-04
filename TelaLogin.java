import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaLogin extends JFrame{

    private final JLabel login = new JLabel("(Login): ", SwingConstants.CENTER);
    private final JTextField JTextFieldlogin = new JTextField();

    private final JLabel senha = new JLabel("(Senha): ", SwingConstants.CENTER);
    private final JPasswordField JPasswordFieldsenha = new JPasswordField();

    private final JButton JButtonLogin = new JButton("Login"); 
    private final JButton cadastrar = new JButton("Cadastrar");
    private final JCheckBox checkBox = new JCheckBox("Aceitar os termos");
    private final JLabel notificacao = new JLabel("Bem vindo! Faça seu login ou seu cadastro");

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    public TelaLogin(){

    setLayout(new GridLayout(6,4,5,5));

    cadastrar.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    FrameNome cadastro = new FrameNome(); 
                    cadastro.setDefaultCloseOperation(ABORT);
                } catch (Exception e) {
                    System.out.println("Algo não deu certo, erro: " + e);                    
                }
            }
        }
    );

    JButtonLogin.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    if (JTextFieldlogin.getText().trim().length() > 0) {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlLogin = "select * from `" + dbPadrao + "`.`" + tblPadrao + "`" + " where `email` = '" + JTextFieldlogin.getText() + "' and `senha` = '" + String.valueOf(JPasswordFieldsenha.getPassword()) + "';";
                        Statement stmSqlLogin = conexao.createStatement();
                        ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
                        
                        if (rstSqlLogin.next()) {
                            TelaPosLogin appMenuFrame = new TelaPosLogin();
                            appMenuFrame.setDefaultCloseOperation(ABORT);
                            notificacao.setText("Login efetuado com sucesso");
                        } else {
                            notificacao.setText("Não foi encontrado o login e/ou senha digitados! Por favor, verifique e tente novamente.");
                        }
                    }    
                }   catch (Exception e) {
                    System.out.println(e);                
                    }
            }                    
        }
    );
    
    add(login);
    add(new JLabel());
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
    add(notificacao);

    setSize(550, 250);
    setVisible(true);
    }   

    public static String setHtmlFormat(String strText){
        return "<html><body>" + strText + "</body></html>";
    }
    public static void main(String[] args) {
        Connection conectar = MySQLConnector.conectar();
        TelaLogin login = new TelaLogin();
        login.setDefaultCloseOperation(ABORT);
    }
}
