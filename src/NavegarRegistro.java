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
    public static String[] RegistroAnterior(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlRegistroAnterior = "select * from `"+ db +"`.`"+ tbl + "`ORDER BY `id` desc limit 1";
        Statement stmSqlRegistroAnterior = conexao.createStatement();
        ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
        rstSqlRegistroAnterior.previous();
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
        String strSqlProximoRegistro = "select * from `"+ db +"`.`"+ tbl + "`ORDER BY `id` WHERE  (`id` > '0');";
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
    // public static String[] atualizarRegistro(String db, String tbl) throws Exception {
    //     Connection conexao = MySQLConnector.conectar();
    //     String strSqlatualizarRegistro = "update * from `"+ db +"`.`"+ tbl + "`;";
    //     Statement stmSqlatualizarRegistro = conexao.createStatement();
    //     ResultSet rstSqlatualizarRegistro = stmSqlatualizarRegistro.executeQuery(strSqlatualizarRegistro);
        
    //     String[] resultado = {"","",""};     
    //         resultado[0] = rstSqlatualizarRegistro.getString("id"),
    //         resultado[1] = rstSqlatualizarRegistro.getString("nome"),
    //         resultado[2] = rstSqlatualizarRegistro.getString("email"),
    //         resultado[3] = rstSqlatualizarRegistro.getString("senha")

    //         stmSqlatualizarRegistro.close();
    //         return resultado;
    // }
    public static String[] deletarRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqldeletarRegistro = "DELETE FROM `db_teste`.`tbl_teste` WHERE (`id` > '0');";
        Statement stmSqldeletarRegistro = conexao.createStatement();
        ResultSet rstSqldeletarRegistro = stmSqldeletarRegistro.executeQuery(strSqldeletarRegistro);
        rstSqldeletarRegistro.next();
        String[] resultado = {
            rstSqldeletarRegistro.getString("id"),
            rstSqldeletarRegistro.getString("nome"),
            rstSqldeletarRegistro.getString("email"),
            rstSqldeletarRegistro.getString("senha")
        }
            ;
        stmSqldeletarRegistro.close();
        return resultado;
    }      
}



