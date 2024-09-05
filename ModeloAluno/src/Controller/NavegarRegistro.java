package Controller;
import java.sql.*;
import model.MySQLConnector;

public class NavegarRegistro{
    public static String[] primeiroRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlPrimeiroRegistro = "select * from `"+ db +"`.`"+ tbl + "`;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlPrimeiroRegistro.next();
        String[] resultado = {
            rstSqlPrimeiroRegistro.getString("id"),
            rstSqlPrimeiroRegistro.getString("nome"),
            rstSqlPrimeiroRegistro.getString("email"),
        }
            ;
        stmSqlPrimeiroRegistro.close();
        return resultado;
    }
    public static String[] RegistroAnterior(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();

        int idPessoa = Integer.parseInt(id);
        int proximoId = idPessoa - 1;

        if (proximoId >= 1) {
            String strSqlRegistroAnterior = "select * from `" + db + "`.`" + tbl + "` order by `id` desc;";
            Statement stmSqlRegistroAnterior = conexao.createStatement();
            ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
            String[] resultado = {"","",""};
            while (rstSqlRegistroAnterior.next()) {
                if (id.equals(rstSqlRegistroAnterior.getString("id"))) {
                    rstSqlRegistroAnterior.next();
                    resultado[0] = rstSqlRegistroAnterior.getString("id");
                    resultado[1] = rstSqlRegistroAnterior.getString("nome");
                    resultado[2] = rstSqlRegistroAnterior.getString("email");
                    break;
                }
            }
            stmSqlRegistroAnterior.close();
            if (resultado[0] == "") {
                return null;
            } else {
                return resultado;
            }
        } else {
            return null;
        }
    }
    public static String[] proximoRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlProximoRegistro = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            String[] resultado = {"","",""};
            while (rstSqlProximoRegistro.next()) {
                if (id.equals(rstSqlProximoRegistro.getString("id"))) {
                    System.out.print(id);
                    rstSqlProximoRegistro.next();
                    resultado[0] = rstSqlProximoRegistro.getString("id");
                    resultado[1] = rstSqlProximoRegistro.getString("nome");
                    resultado[2] = rstSqlProximoRegistro.getString("email");
                    break;
                }
            }
            stmSqlProximoRegistro.close();
            if (resultado[0] == "") {
                return null;
            } else {
                return resultado;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public static String[] ultimoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlultimoRegistro = "select * from `"+ db +"`.`"+ tbl + "`ORDER BY `id` DESC;";
        Statement stmSqlultimoRegistro = conexao.createStatement();
        ResultSet rstSqlultimoRegistro = stmSqlultimoRegistro.executeQuery(strSqlultimoRegistro);
        rstSqlultimoRegistro.next();
        String[] resultado = {
            rstSqlultimoRegistro.getString("id"),
            rstSqlultimoRegistro.getString("nome"),
            rstSqlultimoRegistro.getString("email"),
            rstSqlultimoRegistro.getString("senha")
        }
            ;
        stmSqlultimoRegistro.close();
        return resultado;
    }
    public static boolean atualizarRegistro(String db, String tbl, String id, String nome, String email, char[] senha) throws Exception {       
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlUltimoRegistro = "update `" + db + "`.`" + tbl + "` set `nome` = '" + nome + "', `email` = '" + email + "', `senha` = '" + String.valueOf(senha) + "' where `id` = " + id + ";";
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            stmSqlUltimoRegistro.addBatch(strSqlUltimoRegistro);
            stmSqlUltimoRegistro.executeBatch();
            stmSqlUltimoRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static int ProximoId(String db, String tbl) throws SQLException {
        int proximoId = 0;
        Connection conexao = MySQLConnector.conectar();
        Statement statement = conexao.createStatement();
        String query = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + db + "' AND TABLE_NAME = '" + tbl + "'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            proximoId = resultSet.getInt("AUTO_INCREMENT");
        }

        resultSet.close();
        statement.close();
        conexao.close();

        return proximoId;
    }
}



