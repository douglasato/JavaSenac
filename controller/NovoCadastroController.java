package controller;
import model.*;
import view.*;
import javax.swing.*;
import java.awt.*;

public class NovoCadastroController extends NovoCadastroView {
    public static final String dbPadrao = "db_teste";
    public static final String tblPadrao = "tbl_teste";
    public static String fileFullPath = "";
    public static String fileFullName = "";

    public static void notificarUsuario(String textoNotificacao) {
        notificacaoJLabel.setText(setHtmlFormat(textoNotificacao));
    }

    public static void mostrarFoto() {
        try {
            ImageIcon img = new ImageIcon(new ImageIcon(fileFullPath).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            lblImg.setIcon(img);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public static void memorizarArquivo(String fullPath, String fullName) {
        fileFullPath = fullPath;
        fileFullName = fullName;
    }

    public static void novoCadastroController() {
        NovoCadastroModel.novoCadastro(nomeJTextField.getText().trim(), emailJTextField.getText().trim(), String.valueOf(senhaJPasswordField.getPassword()).trim());
    }

    public static void exibirMenu() {
        MenuFrameView.appMenuFrame.setVisible(true);
    }

    public static void fecharNovoCadastroView() {
        MenuFrameView.appMenuFrame.dispose();
    }

    public static void selecionarArquivoController() {
        NovoCadastroModel.copyFile();
    }

    public static String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "</body></html>";
    }

    public static void removerArquivo() {
        NovoCadastroModel.removerArquivoModel(fileFullPath);
    }

    public static void limparCampos() {
        nomeJTextField.setText("");
        emailJTextField.setText("");
        senhaJPasswordField.setText("");
        lblImg.setIcon(definirFoto("avatar.png"));
    }

    public static ImageIcon definirFoto(String foto) {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\view\\img\\" + foto).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}