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

    public static String[] ultimoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlultimoRegistro = "select * from `"+ db +"`.`"+ tbl + "`;";
        Statement stmSqlultimoRegistro = conexao.createStatement();
        ResultSet rstSqlultimoRegistro = stmSqlultimoRegistro.executeQuery(strSqlultimoRegistro);
        rstSqlultimoRegistro.last();
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

    public static String[] atualizar(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlatualizarRegistro = "select * from `"+ db +"`.`"+ tbl + "`;";
        Statement stmSqlatualizarRegistro = conexao.createStatement();
        ResultSet rstSqlatualizarRegistro = stmSqlatualizarRegistro.executeQuery(strSqlatualizarRegistro);
        
        String[] resultado = {
            rstSqlatualizarRegistro.getString("id"),
            rstSqlatualizarRegistro.getString("nome"),
            rstSqlatualizarRegistro.getString("email"),
            rstSqlatualizarRegistro.getString("senha")
        }
            ;
        stmSqlatualizarRegistro.close();
        return resultado;
    }


}
