import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameNome extends JFrame{
    private final JTextField nomeJTextField = new JTextField();
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nome = new JLabel("Nome: ");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JButton atualizar = new JButton("✓");
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
        setLayout(new GridLayout( 6, 4, 5, 5));

        // primeiroRegistro.addActionListener(
        //     new ActionListener() {
        //         public String actionPerformed(ActionEvent event){
        //             String id;
        //             try {
        //                 if(id != 1){
        //                     id.
        //                     return id;
        //                 }
        //                 return id;
        //             } catch (Exception e) {
        //                 String a = "Algo de errado não está certo";
        //                 return a;
        //             }
        //         }
        //     }
        // );
        
        anterior.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    try {
                        
                    } catch (Exception e) {

                        return;
                    }
                }
            }
        );

        proximo.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    try {
                        
                    } catch (Exception e) {

                        return;
                    }
                }
            }
        );

        ultimoRegistro.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try {
                        
                    } catch (Exception e) {

                        return;
                    }
                }
            }
        );

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String id;
                    String nome;
                    String email;
                    String senha;

                    try {
                        id = nomeJTextFieldid.getText();
                        nome = nomeJTextField.getText();
                        email = nomeJTextFieldid.getText();
                        senha = nomeJTextFieldid.getText();

                        InserirRegistro.cadastrar("db_teste", "tbl_teste", "id", "nome", "email", "senha", id, nome, email, senha);
                        // colocando id, nome, email e senha no banco de dados
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
        add(atualizar);
        add(new JLabel());

        add(nome);
        add(nomeJTextField);
        add(new JLabel());
        add(new JLabel());

        add(email);
        add(nomeJTextFieldemail);
        add(new JLabel());
        add(new JLabel());

        add(senha);
        add(nomeJTextFieldsenha);
        add(new JLabel());
        add(new JLabel());

        add(primeiroRegistro);
        add(anterior);
        add(proximo);
        add(ultimoRegistro);

        add(notificacaoJLabel);
        add(new JLabel());
        add(new JLabel());
        add(cadastrarJButton);

        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        FrameNome application = new FrameNome();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
