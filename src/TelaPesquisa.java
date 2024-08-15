import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class TelaPesquisa extends JFrame{

    private final JLabel nome = new JLabel("Nome: ");
    private final JTextField nomeJTextField = new JTextField();
    
    private final JLabel email = new JLabel("Email: ");
    private final JTextField emailJTextField = new JTextField();

    private final JButton pesquisar = new JButton("🔍");

    public TelaPesquisa(){

    setLayout(new GridLayout (3, 3, 5, 5) );

    pesquisar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            try {
                String strSqlPesquisaRegistro = "select * from `db_teste`.`tbl_teste`;";
                // ResultSet resultado = stmSqlPesquisaRegistro.executeQuery(strSqlPesquisaRegistro);

                nomeJTextField.getText();
                emailJTextField.getText();

                if(nomeJTextField.getText() == strSqlPesquisaRegistro){
                    System.out.println("Registro encontrado");
                }else{
                    System.out.println("Nenhum registro encontrado");
                }

            } catch (Exception e) {
                System.out.println("Algo de errado não está certo: " + e);
            }
        }
    }        
    );
    
    add(nome);
    add(nomeJTextField);
    add(new JLabel());     

    add(email);
    add(emailJTextField);
    add(new JLabel()); 
    add(new JLabel()); 

    add(pesquisar);

    setSize(400, 150);
    setVisible(true);
    }
    
}
