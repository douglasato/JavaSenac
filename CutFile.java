import javax.swing.*;
import java.nio.file.*;
import java.io.*;

public class CutFile extends UploadFile{
    public static void cutFile() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja mover para outro diretório: ");
            chooser.setApproveButtonText("Mover arquivo");

            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to move this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } else {
                System.out.println("Que pena!");
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose to move this folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path: " + chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("Deu ruim!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            Files.move(pathOrigin, pathDestination);
            // Files.delete(pathDestination);
        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo. Erro: " + e);
        }
    }

    public static void main(String[] args) {
        cutFile();
    }
}
