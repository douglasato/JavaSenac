import java.sql.*;

public class PesquisarRegistro {

    public static String[] pesquisarNome(String db, String tbl, String nome, String email) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try {
            String strSqlPesquisaNome = "select * from `" + db + "`.`" + tbl + "` where nome like '%" + nome + "%' or email like '%" + email + "%' order by id asc limit 1;";
            Statement stmSqlPesquisaNome = conexao.createStatement();
            ResultSet rstSqlPesquisaNome = stmSqlPesquisaNome.executeQuery(strSqlPesquisaNome);
            rstSqlPesquisaNome.next();
            String[] resultado = {
                rstSqlPesquisaNome.getString("id"),
                rstSqlPesquisaNome.getString("nome"),
                rstSqlPesquisaNome.getString("email")
            };
            stmSqlPesquisaNome.close();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }
}