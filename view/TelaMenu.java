package view;

import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class TelaMenu extends JFrame{
    private final JLabel Menu = new JLabel("Menu:");
    private final JLabel Img = new JLabel("Imagem");

    private final JLabel Xbacon = new JLabel("X-bacon");
    private final JLabel Xcalabresa = new JLabel("X-calabresa");
    private final JLabel Xegg = new JLabel("X-egg");
    private final JLabel Xpernil = new JLabel("X-pernil");
    private final JLabel Xsalada = new JLabel("X-salada");
    private final JLabel hamburguer = new JLabel("Hamburguer");

    private final JMenuBar roll = new JMenuBar();

    public TelaMenu(){
        super("Menu");

        setLayout(new GridLayout(7,1,5,5));

        JPanel pnlLinha1 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha2 = new JPanel(new GridLayout(2,1,5,5));
        JPanel pnlLinha3 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha4 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha5 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha6 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha7 = new JPanel(new GridLayout(1,2,5,5));
        JPanel pnlLinha8 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha9 = new JPanel(new GridLayout(1,1,5,5));
        JPanel pnlLinha10 = new JPanel(new GridLayout(1,1,5,5));

       add(Menu);
       pnlLinha1.add(new JLabel());
        
       add(roll);

       add(Xsalada);
       Icon Xsalada = new ImageIcon(getClass().getResource(".//lancheImg/xsalada_0.0706481693954325.jpg"));
       add(new JLabel(Xsalada));

       add(Xbacon);
       Icon Xbacon = new ImageIcon(getClass().getResource(".//lancheImg/xbacon_0.7514882325936989.jpg"));
       add(new JLabel(Xbacon));

       add(Xcalabresa);
       Icon Xcalabresa = new ImageIcon(getClass().getResource(".//lancheImg/xcalabresa_0.4809049869877705.jpg"));
       add(new JLabel(Xcalabresa));

       add(Xegg);
       Icon Xegg = new ImageIcon(getClass().getResource(".//lancheImg/xegg_0.3840844982040249.jpg"));
       add(new JLabel(Xegg));

       add(Xpernil);
       Icon Xpernil = new ImageIcon(getClass().getResource(".//lancheImg/xpernil_0.19231450789890447.jpg"));
       add(new JLabel(Xpernil));

       add(hamburguer);
       Icon hamburguer = new ImageIcon(getClass().getResource(".//lancheImg/hamburguer_0.11979894911055855.jpg"));
       add(new JLabel(hamburguer));

    setVisible(true);
    setSize(800, 350);
    }

    public static TelaMenu appTelaMenu;
    public static void main(String[] args) {
        appTelaMenu = new TelaMenu();
        appTelaMenu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
