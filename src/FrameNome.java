import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameNome extends JFrame{
    private final JTextField nomeJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nome = new JLabel("Nome: ");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JLabel id = new JLabel("ID: ");
    private final JTextField nomeJTextFieldid = new JTextField();
    private final JLabel email = new JLabel("Email: ");
    private final JTextField nomeJTextFieldemail = new JTextField();
    private final JLabel senha = new JLabel("Senha: ");
    private final JTextField nomeJTextFieldsenha = new JTextField();
    private final JButton primeiroRegistro = new JButton("<<");
    private final JButton anterior = new JButton("<");
    private final JButton proximo = new JButton(">");
    private final JButton ultimoRegistro = new JButton(">>");

    public FrameNome(){
        super("Cadastro");
        setLayout(new GridLayout( 6, 4, 4, 4));

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String nome;
                    try {
                        // id = nomeJTextFieldid.getText();
                        nome = nomeJTextField.getText();
                        // email = nomeJTextFieldid.getText();
                        // senha = nomeJTextFieldid.getText();

                        InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", nome);
                        //colocando id, nome, email e senha
                        // ação para incluir o cadastro no banco de dados;
                    } catch (NumberFormatException ex) {
                        System.out.println("Digite alguma coisa.");  
                        return;                  
                    }
                }
            }
        );
        add(id);
        add(nomeJTextFieldid);
        add(nome);
        add(nomeJTextField);
        add(email);
        add(nomeJTextFieldemail);
        add(senha);
        add(nomeJTextFieldsenha);
        add(cadastrarJButton);
        add(notificacaoJLabel);
        add(primeiroRegistro);
        add(anterior);
        add(proximo);
        add(ultimoRegistro);
        setSize(275, 200);
        setVisible(true);    
    }
    public static void main(String[] args) {
        FrameNome application = new FrameNome();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
