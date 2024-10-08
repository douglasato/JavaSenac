package view;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame {
    public MenuFrame() {
        super("Perfect Burguer");

        JMenu usuarioMenu = new JMenu("Usuários");
        usuarioMenu.setMnemonic('U');

        JMenuItem cadastrarMenu = new JMenuItem("Cadastrar");
        cadastrarMenu.setMnemonic('C');
        usuarioMenu.add(cadastrarMenu);

        JMenuItem pesquisarMenu = new JMenuItem("Pesquisar");
        pesquisarMenu.setMnemonic('P');
        usuarioMenu.add(pesquisarMenu);

        JMenuItem atualizarMenu = new JMenuItem("Atualizar");
        atualizarMenu.setMnemonic('A');
        usuarioMenu.add(atualizarMenu);

        JMenuItem removerMenu = new JMenuItem("Remover");
        removerMenu.setMnemonic('R');
        usuarioMenu.add(removerMenu);

        JMenuItem cardapio = new JMenuItem("Menu");
        cardapio.setMnemonic('M');
        usuarioMenu.add(cardapio);

        atualizarMenu.addActionListener (
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // EditarCadastro application = new EditarCadastro();
                    // application.setDefaultCloseOperation(HIDE_ON_CLOSE);
                }
            }
        );

        cadastrarMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    NovoCadastro cadastro = new NovoCadastro();
                    cadastro.setDefaultCloseOperation(HIDE_ON_CLOSE);
                }
            }
        );

        pesquisarMenu.addActionListener(
            new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent event){
                TelaPesquisa PesquisaCadastro = new TelaPesquisa();
                PesquisaCadastro.setDefaultCloseOperation(HIDE_ON_CLOSE);
             }   
            }
        );

        removerMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    TelaRemover Remove = new TelaRemover();
                    Remove.setDefaultCloseOperation(HIDE_ON_CLOSE);
                }
            }
        );

        cardapio.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    TelaMenu Menu = new TelaMenu();
                    Menu.setDefaultCloseOperation(HIDE_ON_CLOSE);
                }
            }
        );

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');

        usuarioMenu.add(exitItem);
        exitItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    int confirmDialog = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair do sistema?", "Mensagem do sistema", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println(confirmDialog);
                    if (confirmDialog <= 0) {
                        System.exit(0);
                    }
                }
            }
        );

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(usuarioMenu);

        setSize(500, 500);
        setVisible(true);
    }

    public static void abrirEditarCadastro() {
        // EditarCadastro application = new EditarCadastro();
        // application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static int confirmarSaida() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?",
                "Mensagem do sistema", JOptionPane.PLAIN_MESSAGE) > 0) {
            return EXIT_ON_CLOSE;
        } else {
            return DO_NOTHING_ON_CLOSE;
        }
    }

    public static MenuFrame menuFrame = null;

    public static void main(String[] args) {
        JFrame f = new JFrame("Imagem");
        ImageIcon icon = new ImageIcon("//img/perfect-burger-logo.jpg");
        f.setVisible(true);
        menuFrame = new MenuFrame();
        menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}