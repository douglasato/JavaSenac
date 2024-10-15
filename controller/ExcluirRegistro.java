package controller;
import java.sql.*;
import model.MySQLConnector;

public class ExcluirRegistro {
    public static boolean deletarRegistro(String db, String tbl, String id) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqldeletarRegistro = "DELETE FROM `db_teste`.`tbl_teste` WHERE `id` = " + id + ";";
            Statement stmSqldeletarRegistro = conexao.createStatement();
            stmSqldeletarRegistro.addBatch(strSqldeletarRegistro);
            stmSqldeletarRegistro.executeBatch();
            stmSqldeletarRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
