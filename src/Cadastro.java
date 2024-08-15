import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Cadastro extends JFrame {
    private String strNome, strEmail;

    private final JLabel tituloJLabel = new JLabel("Cadastro");

    private final JLabel idJLabel = new JLabel("ID :");
    private final JLabel idValor = new JLabel();

    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JTextField nomeJTextField = new JTextField();

    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JTextField emailJTextField = new JTextField();

    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JPasswordField senhaJTextField = new JPasswordField();

    private final JButton primeiroJButton = new JButton("<<");
    private final JButton anteriorJButton = new JButton("<");
    private final JButton proximoJButton = new JButton(">");
    private final JButton ultimoJButton = new JButton(">>");

    private final JButton novoJButton = new JButton("Novo Registro");
    private final JButton verJButton = new JButton("🔍");
    private final JButton editarJButton = new JButton("✓");
    private final JButton deletarJButton = new JButton("🚮");

    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    public Cadastro() {
        super("Cadastro");
        setLayout(new GridLayout(8,4,5,5));

        JPanel linha1 = new JPanel(new GridLayout(1, 1, 5, 5));

        JPanel linha2 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha3 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha4 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha5 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha6 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel linha7 = new JPanel(new GridLayout(1, 4, 5, 5));

        JPanel linha8 = new JPanel(new GridLayout(1, 1, 5, 5));

        editarJButton.setToolTipText("Atualizar");
        editarJButton.setEnabled(false);

        verJButton.setToolTipText("Ver");
        novoJButton.setToolTipText("Novo");
        deletarJButton.setToolTipText("Deletar");

        idValor.setEnabled(false);
        primeiroJButton.setEnabled(false);
        anteriorJButton.setEnabled(false);

        editarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean atualizou = false;
                    if (idValor.getText().trim().equals("")) {
                        try {
                            atualizou = InserirRegistro.cadastrar("db_teste", "tbl_teste", nomeJTextField.getText(), emailJTextField.getText(), senhaJTextField.getPassword());
                            novoJButton.setEnabled(true);
                            verJButton.setEnabled(true);
                            editarJButton.setEnabled(false);

                            String[] resultado = NavegarRegistro.ultimoRegistro("db_teste", "tbl_teste");
                            idValor.setText(resultado[0]);
                            nomeJTextField.setText(resultado[1]);
                            strNome = nomeJTextField.getText();
                            emailJTextField.setText(resultado[2]);
                            strEmail = emailJTextField.getText();
                            editarJButton.setEnabled(false);
                            proximoJButton.setEnabled(false);
                            ultimoJButton.setEnabled(false);
                            primeiroJButton.setEnabled(true);
                            anteriorJButton.setEnabled(true);
                            notificacaoJLabel.setText("Cadastro inserido com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Ops! Deu ruim, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim o cadastro...");
                        }
                    } else {
                        try {
                            atualizou = NavegarRegistro.atualizarRegistro("db_teste", "tbl_teste", idValor.getText(), nomeJTextField.getText(), emailJTextField.getText(), senhaJTextField.getPassword());
                            notificacaoJLabel.setText("Cadastro atualizado com sucesso!");
                            editarJButton.setEnabled(false);
                        } catch (Exception e) {
                            System.out.println("Ops! Deu ruim, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim atualizar o cadastro...");
                        }
                    }
                }
            }
        );

        primeiroJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String[] resultado;
                    try {
                        resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        strNome = nomeJTextField.getText();
                        emailJTextField.setText(resultado[2]);
                        strEmail = emailJTextField.getText();
                        editarJButton.setEnabled(false);
                        primeiroJButton.setEnabled(false);
                        anteriorJButton.setEnabled(false);
                        proximoJButton.setEnabled(true);
                        ultimoJButton.setEnabled(true);
                        notificacaoJLabel.setText("Primeiro registro posicionado com sucesso.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
                        return;
                    }
                }
            }
        );

        anteriorJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (idValor.getText().length() > 0) {
                        String[] resultado;
                        try {
                            resultado = NavegarRegistro.RegistroAnterior("db_teste", "tbl_teste", idValor.getText());
                            if (resultado != null) {
                                idValor.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                proximoJButton.setEnabled(true);
                                ultimoJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro retrocedido com sucesso.");
                            } else {
                                primeiroJButton.setEnabled(false);
                                anteriorJButton.setEnabled(false);
                                notificacaoJLabel.setText("Já está no primeiro registro, por isso não é possível retroceder ao registro anterior.");
                            }
                        } catch(Exception e) {
                            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
                            return;
                        }
                    } else {
                        notificacaoJLabel.setText("Não foi possível retroceder o registro, pois não há um id válido atual.");
                    }
                }
            }
        );

        proximoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (idValor.getText().length() > 0) {
                        String[] resultado;
                        try {
                            resultado = NavegarRegistro.proximoRegistro("db_teste", "tbl_teste", idValor.getText());
                            if (resultado != null) {
                                idValor.setText(resultado[0]);
                                nomeJTextField.setText(resultado[1]);
                                strNome = nomeJTextField.getText();
                                emailJTextField.setText(resultado[2]);
                                strEmail = emailJTextField.getText();
                                editarJButton.setEnabled(false);
                                primeiroJButton.setEnabled(true);
                                anteriorJButton.setEnabled(true);
                                notificacaoJLabel.setText("Registro avançado com sucesso.");
                            } else {
                                notificacaoJLabel.setText("Já está no último registro, por isso não é possível avançar o registro.");
                                proximoJButton.setEnabled(false);
                                ultimoJButton.setEnabled(false);
                            }
                        } catch(Exception e) {
                            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o próximo. Veja o erro: " + e);
                            return;
                        }
                    } else {
                        notificacaoJLabel.setText("Não foi possível avançar o registro, pois não há um id válido atual.");
                    }
                }
            }
        );

        ultimoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        String[] resultado = NavegarRegistro.ultimoRegistro("db_teste", "tbl_teste");
                        idValor.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        strNome = nomeJTextField.getText();
                        emailJTextField.setText(resultado[2]);
                        strEmail = emailJTextField.getText();
                        editarJButton.setEnabled(false);
                        proximoJButton.setEnabled(false);
                        ultimoJButton.setEnabled(false);
                        primeiroJButton.setEnabled(true);
                        anteriorJButton.setEnabled(true);
                        notificacaoJLabel.setText("Último registro posicionado com sucesso.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
                        return;
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
                        emailJTextField.setText("");
                        strEmail = "";
                        senhaJTextField.setText("");
                        editarJButton.setEnabled(true);
                        novoJButton.setEnabled(false);
                        verJButton.setEnabled(false);
                        deletarJButton.setEnabled(true);

                        primeiroJButton.setEnabled(false);
                        anteriorJButton.setEnabled(false);
                        proximoJButton.setEnabled(false);
                        ultimoJButton.setEnabled(false);

                        nomeJTextField.requestFocus();

                        notificacaoJLabel.setText("Digite nome, email e senha.");
                    } catch(Exception e) {
                        System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
                        return;
                    }
                }
            }
        );

        nomeJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
            }
        });

        emailJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
            }
        });

        senhaJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampos();
            }
        });

        linha1.add(tituloJLabel);
        add(linha1);

        linha2.add(idJLabel);
        linha2.add(idValor);
        add(linha2);

        linha3.add(nomeJLabel);
        linha3.add(nomeJTextField);
        add(linha3);

        linha4.add(emailJLabel);
        linha4.add(emailJTextField);
        add(linha4);

        linha5.add(senhaJLabel);
        linha5.add(senhaJTextField);
        add(linha5);

        linha6.add(primeiroJButton);
        linha6.add(anteriorJButton);
        linha6.add(proximoJButton);
        linha6.add(ultimoJButton);
        add(linha6);

        linha7.add(novoJButton);
        linha7.add(verJButton);
        linha7.add(editarJButton);
        linha7.add(deletarJButton);
        add(linha7);

        linha8.add(notificacaoJLabel);
        add(linha8);

        // add(container);

        setSize(500, 300);
        setVisible(true);
        iniciarCampos();
    }

    public void verificarCampos() {
        if (!strNome.equals(nomeJTextField.getText())) {
            editarJButton.setEnabled(true);
        } else if (!strEmail.equals(emailJTextField.getText())) {
            editarJButton.setEnabled(true);
        } else if (senhaJTextField.getText().length() > 0) {
            editarJButton.setEnabled(true);
        } else {
            editarJButton.setEnabled(false);
        }
    }

    public void iniciarCampos() {
        try {
            String[] resultado = NavegarRegistro.primeiroRegistro("db_teste", "tbl_teste");
            notificacaoJLabel.setText("Primeio registro posicionado com sucesso");
            if (resultado != null) {
                idValor.setText(resultado[0]);
                nomeJTextField.setText(resultado[1]);
                strNome = nomeJTextField.getText();
                emailJTextField.setText(resultado[2]);
                strEmail = emailJTextField.getText();
                editarJButton.setEnabled(false);
            } else {
                notificacaoJLabel.setText("Já está no primeiro registro, por isso não é possível retroceder ao registro anterior.");
            }
        } catch(Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
        }
    }

    public static void main(String[] args) {
        Cadastro application = new Cadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
