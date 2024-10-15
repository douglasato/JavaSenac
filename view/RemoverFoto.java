package view;

import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class RemoverFoto {
    public static void main(String[] args) {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione a imagem que deseja remover: ");
            chooser.setApproveButtonText("Remover essa imagem");

            int returnImg1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

            if(returnImg1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to delete this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } 
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose to delete this folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path: " + chooser.getSelectedFile().getAbsolutePath());
            } 

            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            Files.delete(pathDestination);

        } catch (Exception e) {
            System.out.println("Erro: " + e);        
        }
    }
}
