package view;

import controller.InserirRegistro;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;
import model.MySQLConnector;

public class NovoCadastro extends JFrame {
    private final JLabel nomeJLabel = new JLabel("Digite um nome:", SwingConstants.RIGHT);
    private final JTextField nomeJTextField = new JTextField();
    private String strNome;

    private final JLabel emailJLabel = new JLabel("Digite um email:", SwingConstants.RIGHT);
    private final JTextField emailJTextField = new JTextField();
    private String strEmail;

    private final JLabel senhaJLabel = new JLabel("Digite uma senha:", SwingConstants.RIGHT);
    private final JPasswordField senhaJPasswordField = new JPasswordField();

    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JButton pesquisarFotoJButton = new JButton("Pesquisar com foto");

    private final JLabel notificacaoJLabel = new JLabel("Notificações...", SwingConstants.CENTER);

    private final String dbPadrao = "db_teste";
    private final String tblPadrao = "tbl_teste";

    private String ultimoId = "";

    public NovoCadastro() {
        super("Novo Cadastro");
        setLayout(new GridLayout(5,1,5,5));

        JPanel linha1 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha2 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha3 = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel linha4 = new JPanel(new GridLayout(1, 1, 5, 5));

        JPanel linha5 = new JPanel(new GridLayout(1, 1, 5, 5));

        pesquisarFotoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event){
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisarEmail = "select * from `" + dbPadrao + "`.`" + tblPadrao + "` where `email` = '" + emailJTextField.getText() + "` where `imagem` = '" + pesquisarFotoJButton.getText() +"';";
                        Statement stmSqlPesquisarEmail = conexao.createStatement();
                        ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);

                        JFileChooser chooser = new JFileChooser();

                        chooser.setDialogTitle("Selecione a imagem que deseja cadastrar: ");
                        chooser.setApproveButtonText("Selecionar imagem");
            
                        int returnImg1 = chooser.showOpenDialog(null);
                        String fileFullPath = "";
                        String fileName = "";
            
                            if(returnImg1 == JFileChooser.APPROVE_OPTION) {
                                System.out.println("Você escolheu essa imagem: " + chooser.getSelectedFile().getName().split("."));
            
                                String[] ImgChooser = chooser.getSelectedFile().getName().split("[.]");
                                //imagem.paisagem.jpg -> vetor com 3 posições
            
                                fileName = ImgChooser[ImgChooser.length - 1];
            
                                fileName = "Nome_" + Math.random() + "." + fileName;
                                //Nome_3409099.jpg
            
                                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                                System.out.println("File Full Path: " + fileFullPath);
                            }
            
                        String folderFullPath = "C:\\Users\\uept02-user\\Documents\\DG\\10.10.24\\view\\usuarioImg";
            
                            Path pathOrigin = Paths.get(fileFullPath);
                            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
                            Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);  
                    } catch (Exception e) {
                        System.out.println("Erro: " + e);
                        notificacaoJLabel.setText("Não foi possível realizar o cadastro. Por favor, verifique e tente novamente.");
                    }
                }
            }
        );

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisarEmail = "select * from `" + dbPadrao + "`.`" + tblPadrao + "` where `email` = '" + emailJTextField.getText() + "';";
                        Statement stmSqlPesquisarEmail = conexao.createStatement();
                        ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);
                        if (rstPesquisarEmail.next()) {
                            notificacaoJLabel.setText("Ops! Parece que há um cadastro com esse email. Porfavor, verifique e tente novamente com outro email.");
                            stmSqlPesquisarEmail.close();
                        } else {
                            String strSqlCadastrarRegistro = "insert into `" + dbPadrao + "`.`" + tblPadrao + "` (`nome`,`email`,`senha`) values ('" + nomeJTextField.getText() + "','" + emailJTextField.getText() + "','" + String.valueOf(senhaJPasswordField.getPassword()) +"');";
                            Statement stmSqlCadastrarRegistro = conexao.createStatement();
                            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
                            stmSqlCadastrarRegistro.executeBatch();
                            stmSqlCadastrarRegistro.close();
                            notificacaoJLabel.setText("Cadastro realizado com sucesso!");
                            LoginFrame.lblNotificacoes.setText("Cadastro realizado com sucesso!");
                            LoginFrame.appLoginFrame.setVisible(true);
                            dispose(); // fechar a própria tela, sem fechar a tela anterior
                        }
                    } catch (Exception e) {
                        notificacaoJLabel.setText("Não foi possível realizar o cadastro. Por favor, verifique e tente novamente.");
                    }
                }
            }
        );

        linha1.add(nomeJLabel);
        linha1.add(nomeJTextField);
        add(linha1);

        linha2.add(emailJLabel);
        linha2.add(emailJTextField);
        add(linha2);

        linha3.add(senhaJLabel);
        linha3.add(senhaJPasswordField);
        add(linha3);

        linha4.add(pesquisarFotoJButton);
        add(linha4);

        linha5.add(cadastrarJButton);
        add(linha5);

        linha5.add(notificacaoJLabel);
        add(linha5);

        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        NovoCadastro appNovoCadastro = new NovoCadastro();
        appNovoCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
