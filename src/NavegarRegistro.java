import java.sql.*;

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
            rstSqlPrimeiroRegistro.getString("senha")
        }
            ;
        stmSqlPrimeiroRegistro.close();
        return resultado;
    }
    public static String[] RegistroAnterior(String db, String tbl, int id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlRegistroAnterior = "select * from `"+ db +"`.`"+ tbl + "`ORDER BY `id` DESC LIMIT 1";
        Statement stmSqlRegistroAnterior = conexao.createStatement();
        ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
        rstSqlRegistroAnterior.next();

        int idPessoa = id - 1;

        String[] resultado = {
            rstSqlRegistroAnterior.getString("id"),
            rstSqlRegistroAnterior.getString("nome"),
            rstSqlRegistroAnterior.getString("email"),
            rstSqlRegistroAnterior.getString("senha")
        }
            ;  
        stmSqlRegistroAnterior.close();
        return resultado;
    }
    public static String[] proximoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlProximoRegistro = "select * from `"+ db +"`.`"+ tbl + "`ORDER BY `id` ASC LIMIT 1 WHERE  (`id` > '0');";
        Statement stmSqlProximoRegistro = conexao.createStatement();
        ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
        rstSqlProximoRegistro.next();
        String[] resultado = {
            rstSqlProximoRegistro.getString("id"),
            rstSqlProximoRegistro.getString("nome"),
            rstSqlProximoRegistro.getString("email"),
            rstSqlProximoRegistro.getString("senha")
        }
            ;
        stmSqlProximoRegistro.close();
        return resultado;
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
            String strSqlatualizarRegistro = "update `" + db + "`.`" + tbl + "` set `nome` = '" + nome + "', `email` = '" + email + "',  `senha` = '" + String.valueOf(senha) + "' where `id` = "+ id + ";" ;
            Statement stmSqlatualizarRegistro = conexao.createStatement();
            stmSqlatualizarRegistro.addBatch(strSqlatualizarRegistro);
            stmSqlatualizarRegistro.executeBatch();
            stmSqlatualizarRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    } 
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



