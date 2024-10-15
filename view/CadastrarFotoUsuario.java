package view;

import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class CadastrarFotoUsuario {
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

                    String[] ImgChooser = chooser.getSelectedFile().getName().split("[.]");
                    //foto.usuario.jpg -> vetor com 3 posições

                    fileName = ImgChooser[ImgChooser.length - 1];

                    fileName = "Nome_" + Math.random() + "." + fileName;
                    //Nome_0.03409099.jpg

                    fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println("File Full Path: " + fileFullPath);
                }

            String folderFullPath = "C:\\Users\\uept02-user\\Documents\\DG\\10.10.24\\view\\usuarioImg";

                Path pathOrigin = Paths.get(fileFullPath);
                Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);     
        } catch (Exception e) {
            System.out.println("Deu ruim ! Erro: "+ e);        
        }
    }
}
