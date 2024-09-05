package View;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import Controller.NavegarRegistro;

public class TelaAtualizar extends JFrame{
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

    private final JButton primeiroRegistro = new JButton("<<");
    private final JButton anterior = new JButton("<");
    private final JButton proximo = new JButton(">");
    private final JButton ultimoRegistro = new JButton(">>");
    private final JButton atualizar = new JButton("🔄");

    public TelaAtualizar(){

        super("Atualizar Registro");
        setLayout(new GridLayout(6,1,5,5));

        JPanel pnlLinha1 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha2 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha3 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha4 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha5 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha6 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha7 = new JPanel(new GridLayout(1,2,5,5));
        JPanel pnlLinha8 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha9 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha10 = new JPanel(new GridLayout(1,1,5,5));
    
    add(id);
    pnlLinha1.add(idValor);    
    add(nome);
    pnlLinha2.add(nomeJTextField);
    add(pnlLinha2);

    add(email);
    pnlLinha3.add(JTextFieldemail);
    add(pnlLinha3);
    add(senha);
    pnlLinha4.add(JTextFieldsenha);
    add(pnlLinha4);

    add(primeiroRegistro);
    add(anterior);
    add(proximo);
    add(ultimoRegistro);
    add(atualizar);
    add(notificacaoJLabel);

    idValor.setEnabled(false);
    
    setSize(500, 250);
    setVisible(true);

        primeiroRegistro.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");

                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        JTextFieldemail.setText(resultado[2]);
                        
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
                        return;
                    }
                }
            }
        );

        anterior.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.RegistroAnterior("db_teste", "tbl_teste", idValor.getText());
                        notificacaoJLabel.setText("Registro retornado com sucesso");

                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        JTextFieldemail.setText(resultado[2]);
                        // anteriorRegistro.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
                        return;
                    }
                }
            }
        );

        proximo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.proximoRegistro("db_teste", "tbl_teste", idValor.getText());
                        notificacaoJLabel.setText("Registro avançado com sucesso");

                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        JTextFieldemail.setText(resultado[2]);
                        // proximoRegistro.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
                        return;
                    }
                }
            }
        );

        ultimoRegistro.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.ultimoRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Último registro posicionado com sucesso");

                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        JTextFieldemail.setText(resultado[2]);
                        
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
                        return;
                    }
                }
            }
        );

        atualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){                   
                    boolean att = false;

                    try {
                        att = NavegarRegistro.atualizarRegistro("db_teste", "tbl_teste", idValor.getText(), nomeJTextField.getText(), JTextFieldemail.getText(), JTextFieldsenha.getPassword());

                        notificacaoJLabel.setText("Registro atualizado com sucesso");
                        // atualizarRegistro.setEnabled(true);
                        // atualizando os campos deixando em branco
                    } catch (Exception e) {
                        System.out.println(e);
                        notificacaoJLabel.setText("Deu ruim, tente outra hora");
                        return;
                    }
                    if(att){
                        notificacaoJLabel.setText("Cadastro atualizado com sucesso");
                    }else{
                        notificacaoJLabel.setText("Cadastro não efetuado");
                    }
                }
            }
        );

    try {
        String[] resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
        idValor.setText(resultado[0]);
        nomeJTextField.setText(resultado[1]);
        JTextFieldemail.setText(resultado[2]);

    } catch (Exception e) {
        // TODO: handle exception
    }
    
    }
    public static void main(String[] args){
        TelaAtualizar atualizar = new TelaAtualizar();
        atualizar.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
