package view;

import java.io.*;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class DeleteFile {
    public static void main(String[] args) {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja deletar: ");
            chooser.setApproveButtonText("Deletar esse arquivo");
            
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to delete this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } else {
                System.out.println("Deu ruim!");
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose to delete this folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path: " + chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("Deu ruim!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            Files.delete(pathDestination);
            // Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);
            // Files.delete(pathDestination);
        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo. Erro: " + e);
        }
    }
}
