package view;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import controller.*;

public class TelaRemover extends JFrame{
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
    private final JButton deletar = new JButton("🚮");

    public TelaRemover(){

        super("Remover");
        setLayout(new GridLayout(4,4,4,4));

        idValor.setEnabled(false);

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

        deletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){                   
                    boolean att = false;

                    try {
                        att = ExcluirRegistro.deletarRegistro("db_teste", "tbl_teste", idValor.getText());

                        notificacaoJLabel.setText("Registro atualizado com sucesso");
                        // atualizarRegistro.setEnabled(true);
                        // atualizando os campos deixando em branco
                    } catch (Exception e) {
                        System.out.println();
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
    
    add(id);
    add(idValor);
    add(new JLabel());
    add(nome);
    add(nomeJTextField);
    add(new JLabel());
    add(new JLabel());

    add(email);
    add(JTextFieldemail);
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
  
    add(primeiroRegistro);
    add(anterior);
    add(proximo);
    add(ultimoRegistro);
    add(deletar);

    setSize(450, 250);
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
    public static void main(String[] args){
        TelaRemover remove = new TelaRemover();
        remove.setDefaultCloseOperation(ABORT);
    }
}
