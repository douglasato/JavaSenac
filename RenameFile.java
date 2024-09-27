package view;

import java.io.*;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class RenameFile {
    public static void renameFile() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja renomear: ");
            chooser.setApproveButtonText("Renomear arquivo");

            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String folderFullPath = "";
            String fileName = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                folderFullPath = chooser.getSelectedFile().getParent();
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Não deu bom!");
            }

            String NovoNomeArquivo; 
            NovoNomeArquivo= JOptionPane.showInputDialog(null, "Digite o novo nome do arquivo", fileName);
            
            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + NovoNomeArquivo);

            if(fileFullPath.length() > 0 && folderFullPath.length() > 0 && fileName.length() > 0 && fileName.length() > 0 && NovoNomeArquivo.length() > 0) {
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);
                Files.delete(pathOrigin);
                System.out.println("Arquivo " + chooser.getSelectedFile().getName() + " renomeado");
            } else {
                System.out.println("Não foi possível renomear o arquivo!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível renomear o arquivo. Erro: " + e);
        }
    }
    public static void main(String[] args) {
        renameFile();
    }
}
