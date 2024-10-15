package view;

import controller.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class TelaPesquisa extends JFrame{

    private final JLabel aviso = new JLabel("Digite abaixo o nome do usuário que deseja encontrar: ");
    private final JLabel nome = new JLabel("Nome: ");
    private final JTextField nomeJTextField = new JTextField();
    
    private final JLabel email = new JLabel("Email: ");
    private final JTextField emailJTextField = new JTextField();

    private final JLabel notificacaoJLabel = new JLabel("...");

    private final JButton pesquisar = new JButton("🔍");

    public TelaPesquisa(){
    
    super("Pesquisa");
    setLayout(new GridLayout (3, 3, 5, 5) );

    pesquisar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            try {
                String strSqlPesquisaRegistro = "select * from `db_teste`.`tbl_teste`;";
                // ResultSet resultado = stmSqlPesquisaRegistro.executeQuery(strSqlPesquisaRegistro);

                nomeJTextField.getText();
                emailJTextField.getText();

                if(nomeJTextField.getText() == strSqlPesquisaRegistro){
                    notificacaoJLabel.setText("Registro encontrado");
                }else{
                    notificacaoJLabel.setText("Nenhum registro encontrado");
                }

            } catch (Exception e) {
                System.out.println("Algo de errado não está certo: " + e);
            }
        }
    }        
    );
    
    add(aviso);
    add(new JLabel());
    add(nomeJTextField);
    add(pesquisar);
    add(new JLabel()); 
    add(notificacaoJLabel);

    setSize(400, 200);
    setVisible(true);
    }
    public static void main(String[] args){
        TelaPesquisa pesquisa = new TelaPesquisa();
        pesquisa.setDefaultCloseOperation(ABORT);
    }
}


