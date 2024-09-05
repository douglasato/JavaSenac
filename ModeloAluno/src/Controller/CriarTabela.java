package Controller;
import java.sql.*;
import model.MySQLConnector;

public class CriarTabela {
    public static void main(String[] args) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlStringTabela = "create table `db_teste`.`tbl_teste`(`id` INT AUTO_INCREMENT PRIMARY KEY, `nome` varchar(255) not null, `email` varchar(255) not null, `senha` varchar(255) not null, primary key(`id`));";
            Statement stmSqlCriarTabela = conexao.createStatement();
            stmSqlCriarTabela.addBatch(strSqlStringTabela);
            stmSqlCriarTabela.executeBatch();
            stmSqlCriarTabela.close();
            System.out.println("Tabela criada com sucesso");

        } catch (Exception e) {
          System.out.println("Ocorreu um erro! Erro do tipo: "+ e);
          }
    }
}
