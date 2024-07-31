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
    private final JPasswordField nomeJTextFieldsenha = new JPasswordField();
    private final JButton primeiroRegistro = new JButton("<<");
    private final JButton anterior = new JButton("<");
    private final JButton proximo = new JButton(">");
    private final JButton ultimoRegistro = new JButton(">>");
    private final JButton deletar = new JButton("Deletar");

    public FrameNome(){
        super("Cadastro");
        setLayout(new GridLayout( 6, 4, 5, 5));

        primeiroRegistro.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");
                        nomeJTextFieldid.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        nomeJTextFieldemail.setText(resultado[2]);
                        nomeJTextFieldsenha.setText(resultado[3]);
                        primeiroRegistro.setEnabled(false);
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
                        resultado = NavegarRegistro.RegistroAnterior("db_teste", "tbl_teste", "id");
                        notificacaoJLabel.setText("Registro retornado com sucesso");
                        nomeJTextFieldid.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        nomeJTextFieldemail.setText(resultado[2]);
                        nomeJTextFieldsenha.setText(resultado[3]);
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
                        resultado = NavegarRegistro.proximoRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Registro retornado com sucesso");
                        nomeJTextFieldid.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        nomeJTextFieldemail.setText(resultado[2]);
                        nomeJTextFieldsenha.setText(resultado[3]);
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
                        nomeJTextFieldid.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        nomeJTextFieldemail.setText(resultado[2]);
                        nomeJTextFieldsenha.setText(resultado[3]);
                        ultimoRegistro.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
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
                        email = nomeJTextFieldemail.getText();
                        senha = nomeJTextFieldsenha.getText();

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

        // atualizar.addActionListener(
        //     new ActionListener() {
        //         public void actionPerformed(ActionEvent event){
        //             String[] att;
        //             try {
        //                 att = NavegarRegistro.atualizarRegistro("db_teste", "tbl_teste");
        //                 notificacaoJLabel.setText("Registro atualizado com sucesso");
        //                 nomeJTextFieldid.setText(att[0]);
        //                 nomeJTextField.setText(att[1]);
        //                 nomeJTextFieldemail.setText(att[2]);
        //                 nomeJTextFieldsenha.setText(att[3]);
        //                 atualizarRegistro.setEnabled(true);
        //                 // atualizando os campos deixando em branco
        //             } catch (NumberFormatException ex) {
        //                 System.out.println("algo de errado não está certo: "+ ex);
        //                 return;
        //             }
        //         }
        //     }
        // );
        deletar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.deletarRegistro("db_teste", "tbl_teste", "id");
                        notificacaoJLabel.setText("Registro deletado com sucesso");
                        nomeJTextFieldid.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        nomeJTextFieldemail.setText(resultado[2]);
                        nomeJTextFieldsenha.setText(resultado[3]);
                        // deltando registro;
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
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
        add(deletar);
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
