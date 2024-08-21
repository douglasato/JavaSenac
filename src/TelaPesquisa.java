import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class TelaPesquisa extends JFrame{

    private final JLabel pesquisa = new JLabel("Pesquisa: ");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    public final JTextField campoJTextField = new JTextField();
    public final JTextField JTextFieldnome = new JTextField();
    public final JTextField JTextFieldemail = new JTextField();
    
    private final JButton pesquisar = new JButton("🔍");

    public TelaPesquisa(){

    setLayout(new GridLayout (4, 3, 10, 8) );

    pesquisar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            String[] resultadoPesquisa;
            try {
                resultadoPesquisa = PesquisarRegistro.pesquisarNome("db_teste", "tbl_teste", campoJTextField.getText(), campoJTextField.getText()); //parâmetros db, tbl, nome e email

                if(resultadoPesquisa != null){
                    notificacaoJLabel.setText("Registro encontrado!");
                }else{
                    notificacaoJLabel.setText("Registro não encontrado!");
                }
            } catch (Exception e) {
                notificacaoJLabel.setText("Algo de errado não está certo: " + e);
            }
        }
    }        
    );

    add(pesquisa);
    add(campoJTextField);
    add(new JLabel());     

    add(pesquisar);
    add(new JLabel()); 
    add(notificacaoJLabel);

    setSize(450, 150);
    setVisible(true);
    }
}
