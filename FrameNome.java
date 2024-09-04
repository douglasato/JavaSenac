import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class FrameNome extends JFrame{
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
    private final JButton primeiroRegistro = new JButton("<<");
    private final JButton anterior = new JButton("<");
    private final JButton proximo = new JButton(">");
    private final JButton ultimoRegistro = new JButton(">>");
    private final JButton pesquisar = new JButton("🔍");
    private final JButton deletar = new JButton("Remover");
    private final JButton atualizar = new JButton("🔄");
    private final JButton novoJButton = new JButton("Novo");
    private final JButton editarJButton = new JButton("✓");

    
    // editarJButton.setToolTipText("Atualizar");
    public FrameNome(){
        super("Cadastro");
        setLayout(new GridLayout( 8, 5, 5, 5));

        idValor.setEnabled(false);
        primeiroRegistro.setEnabled(true);
        ultimoRegistro.setEnabled(true);

        try {
            int proximoId = NavegarRegistro.ProximoId("db_teste", "tbl_teste");
            idValor.setText(String.valueOf(proximoId));
        } catch (SQLException e) {
            System.out.println("Erro ao obter próximo ID: " + e);
        }

        editarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean atualizou = false;
                    if (idValor.getText().trim().equals("")) {
                        try {
                            atualizou = InserirRegistro.cadastrar("db_teste", "tbl_teste", nomeJTextField.getText(), JTextFieldemail.getText(), JTextFieldsenha.getPassword());
                            novoJButton.setEnabled(true);
                            editarJButton.setEnabled(false);

                            String[] resultado = NavegarRegistro.ultimoRegistro("db_teste", "tbl_teste");
                            idValor.setText(resultado[0]);
                            nomeJTextField.setText(resultado[1]);
                            strNome = nomeJTextField.getText();
                            JTextFieldemail.setText(resultado[2]);
                            strEmail = JTextFieldemail.getText();
                            editarJButton.setEnabled(false);
                            proximo.setEnabled(false);
                            ultimoRegistro.setEnabled(false);
                            primeiroRegistro.setEnabled(true);
                            anterior.setEnabled(true);
                            notificacaoJLabel.setText("Cadastro inserido com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Ops! Deu ruim, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim o cadastro...");
                        }
                    } else {
                        try {
                            atualizou = NavegarRegistro.atualizarRegistro("db_teste", "tbl_teste", idValor.getText(), nomeJTextField.getText(), JTextFieldemail.getText(), JTextFieldsenha.getPassword());
                            notificacaoJLabel.setText("Cadastro atualizado com sucesso!");
                            editarJButton.setEnabled(false);
                        } catch (Exception e) {
                            System.out.println("Ops! deu problema, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim atualizar o cadastro...");
                        }
                    }
                }
            }
        );

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

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    String nome;
                    String email;
                    String senha;

                    TelaCadastro cadastro = new TelaCadastro();
                    cadastro.setDefaultCloseOperation(ABORT);
                    
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

        atualizar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){                   
                    boolean att = false;

                    TelaAtualizar atualizar = new TelaAtualizar();
                    atualizar.setDefaultCloseOperation(ABORT);

                    try {
                        att = NavegarRegistro.atualizarRegistro("db_teste", "tbl_teste", idValor.getText(), nomeJTextField.getText(), JTextFieldemail.getText(), JTextFieldsenha.getPassword());

                        notificacaoJLabel.setText("Registro atualizado com sucesso");
                        // atualizarRegistro.setEnabled(true);
                        // atualizando os campos deixando em branco
                    } catch (Exception e) {
                        System.out.println();
                        return;
                    }
                    if(att == true){
                        notificacaoJLabel.setText("Cadastro atualizado com sucesso");
                    }else{
                        notificacaoJLabel.setText("Cadastro não atualizado");
                    }
                }
            }
        );

        deletar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    boolean resultado;
                    TelaRemover remove = new TelaRemover();
                    remove.setDefaultCloseOperation(ABORT);
                    try {
                        resultado = ExcluirRegistro.deletarRegistro("db_teste", "tbl_teste", idValor.getText());
                        notificacaoJLabel.setText("Registro deletado com sucesso");
                        // deletando registro;
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo "+ e);
                        return;
                    }
                }
            }
        );

        pesquisar.addActionListener( // pesquisando registro
            new ActionListener(){
                public void actionPerformed(ActionEvent event){

                    try {
                        TelaPesquisa pesquisa = new TelaPesquisa(); 
                        pesquisa.setDefaultCloseOperation(ABORT);

                        editarJButton.setEnabled(false);
                        novoJButton.setEnabled(false);
                        pesquisar.setEnabled(true);
                        deletar.setEnabled(false);

                        primeiroRegistro.setEnabled(false);
                        anterior.setEnabled(false);
                        proximo.setEnabled(false);
                        ultimoRegistro.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("algo não deu certo, erro: " + e);                    
                    }
                }
            }
        );

        novoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    try {
                        idValor.setText("");
                        nomeJTextField.setText("");
                        strNome = "";
                        JTextFieldemail.setText("");
                        strEmail = "";
                        JTextFieldsenha.setText("");
                        editarJButton.setEnabled(false);
                        novoJButton.setEnabled(false);
                        deletar.setEnabled(false);

                        primeiroRegistro.setEnabled(false);
                        anterior.setEnabled(false);
                        proximo.setEnabled(false);
                        ultimoRegistro.setEnabled(false);

                        nomeJTextField.requestFocus();

                        notificacaoJLabel.setText("Digite nome, email e senha.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
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

                        editarJButton.setEnabled(false);
                        novoJButton.setEnabled(false);
                        deletar.setEnabled(false);

                        primeiroRegistro.setEnabled(false);
                        anterior.setEnabled(false);
                        proximo.setEnabled(false);
                        ultimoRegistro.setEnabled(false);
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

        add(pesquisar);
        add(primeiroRegistro);
        add(anterior);
        add(proximo);

        add(ultimoRegistro);
        add(pesquisar);
        add(novoJButton);
        add(deletar);

        add(atualizar);
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
        FrameNome application = new FrameNome();
        application.setDefaultCloseOperation(ABORT);
    }
}
