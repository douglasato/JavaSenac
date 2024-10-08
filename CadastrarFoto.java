package view;

import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;
import java.io.*;

public class CadastrarFoto {
    public static void main(String[] args) {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione a imagem que deseja cadastrar: ");
            chooser.setApproveButtonText("Selecionar imagem");

            int returnImg1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

                if(returnImg1 == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Você escolheu essa imagem: " + chooser.getSelectedFile().getName().split("."));

                    String[] ImgChooser = chooser.getSelectedFile().getName().split(".");

                    fileName = ImgChooser[length - 1];

                    fileName = "Nome_" + Math.random() + "." + fileName;

                    fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println("File Full Path: " + fileFullPath);
                }

            String folderFullPath = "img";

                Path pathOrigin = Paths.get(fileFullPath);
                Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);     
        } catch (Exception e) {
            System.out.println("Deu ruim ! Erro: "+ e);        
        }
    }
}
