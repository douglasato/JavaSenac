package View;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import Controller.InserirRegistro;
import Controller.NavegarRegistro;

public class TelaCadastro extends JFrame{
    private String strNome, strEmail;

    private final JTextField nomeJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nome = new JLabel("Nome: ");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    private final JLabel id = new JLabel("ID : ");
    private final JTextField idValor = new JTextField();

    private final JLabel email = new JLabel("Email: ");
    private final JTextField JTextFieldemail = new JTextField();

    private final JLabel senha = new JLabel("Senha: ");
    private final JPasswordField JTextFieldsenha = new JPasswordField();

    private final JButton login = new JButton("Login");
    
    // editarJButton.setToolTipText("Atualizar");
    public TelaCadastro(){
        super("Cadastro");
        setLayout(new GridLayout( 8, 5, 5, 5));

        idValor.setEnabled(false);

        try {
            int proximoId = NavegarRegistro.ProximoId("db_teste", "tbl_teste");
            idValor.setText(String.valueOf(proximoId));
        } catch (SQLException e) {
            System.out.println("Erro ao obter próximo ID: " + e);
        }

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String nome;
                    String email;
                    String senha;

                    try {
                        nome = nomeJTextField.getText();
                        email = JTextFieldemail.getText();
                        senha = JTextFieldsenha.getText();
                        if(nome.trim().length() > 0){
                            if (email.trim().length() > 0) {
                                if(senha.trim().length() > 0){
                                    InserirRegistro.cadastrar("db_teste", "tbl_teste", nomeJTextField.getText(), JTextFieldemail.getText(), JTextFieldsenha.getPassword());
                                }
                            }
                        // colocando id, nome, email e senha no banco de dados
                        // ação para incluir o cadastro no banco de dados;
                        }else{
                            notificacaoJLabel.setText("O cadastro não pode ser efetuado !");
                        }
                    } catch (Exception ex) {
                        System.out.println("Não deu certo "+ ex);
                        return;
                    }
                }
            }
        );

        login.addActionListener( // vai para tela de login
            new ActionListener(){
                public void actionPerformed(ActionEvent event){

                    try {
                        TelaLogin login = new TelaLogin(); 
                        login.setDefaultCloseOperation(EXIT_ON_CLOSE);

                    } catch (Exception e) {
                        System.out.println("algo não deu certo, erro: " + e);                    
                    }
                }
            }
        );

        add(id);
        add(idValor);
        add(new JLabel());
        add(new JLabel());

        add(nome);
        add(nomeJTextField);
        add(new JLabel());
        add(new JLabel());

        add(email);
        add(JTextFieldemail);
        add(new JLabel());
        add(new JLabel());

        add(senha);
        add(JTextFieldsenha);
        add(new JLabel());
        add(new JLabel());
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(cadastrarJButton);
        add(login);
        add(notificacaoJLabel);

        setSize(500, 250);
        setVisible(true);

        try {
            String[] resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
            idValor.setText(resultado[0]);
            nomeJTextField.setText(resultado[1]);
            JTextFieldemail.setText(resultado[2]);

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public static void main(String[] args) {
        TelaCadastro cadastro = new TelaCadastro();
        cadastro.setDefaultCloseOperation(ABORT);
    }
}
