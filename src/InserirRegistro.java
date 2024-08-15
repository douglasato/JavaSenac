import java.sql.*;

public class InserirRegistro {
    public static boolean cadastrar(String db, String tbl, String nome, String email, char[] senha) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlCadastrarRegistro = "insert into `" + db + "`.`" + tbl + "` (`nome`,`email`,`senha`) values ('" + nome + "','" + email + "','" + String.valueOf(senha) +"');";
            Statement stmSqlCadastrarRegistro = conexao.createStatement();
            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
            stmSqlCadastrarRegistro.executeBatch();
            stmSqlCadastrarRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
