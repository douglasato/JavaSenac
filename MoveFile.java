package view;
import javax.swing.*;
import java.nio.file.*;
import java.io.*;

public class MoveFile extends UploadFile{
    public static void main(String[] args) {
        try {
            JFileChooser chooser = new JFileChooser();
            // chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // esta linha ativa a opção somente pasta
            // chooser.setCurrentDirectory(new java.io.File(".")); // definir o diretório local como diretório padrão
            // chooser.setDialogTitle("Título da janela"); // esta linha define o título da tela do file chooser
            // FileNameExtensionFilter filter = new FileNameExtensionFilter(
            //         "JPG & GIF Images", "jpg", "gif"); // esta linha define o tipo de arquivo e respectivas extensões do mesmo
            // chooser.setFileFilter(filter); // esta linha aplica o filtro de tipos de arquivos a serem selecionados

            chooser.setDialogTitle("Selecione o arquivo que deseja mover para outro diretório: ");
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
}
