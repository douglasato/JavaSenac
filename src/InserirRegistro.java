import java.sql.*;

public class InserirRegistro {
    public static String cadastrar(String db, String tbl, String campoID, String camponome, String campoemail, String camposenha, String id, String nome, String email, String senha) {
        String retorno = "nada aconteceu ainda...";
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlInserirRegistro = "INSERT INTO `" + db + "`.`" + tbl + "` (`" + campoID + "`, `" + camponome + "`, `" + campoemail + "`, `" + camposenha + "`) VALUES ('" + id + "', '" + nome + "', '" + email + "', '" + senha + "');";
            // ('nome', 'email', 'senha') values(\'Teste', \'testeteste.teste\', \'senhaTeste\')
            Statement stmSqlInserirRegistro = conexao.createStatement();
            stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
            stmSqlInserirRegistro.executeBatch();
            stmSqlInserirRegistro.close();
            retorno = "Registro inserido com sucesso";
            System.out.println(retorno);
        } catch (Exception e) {
            retorno = "Ocorreu um erro: "+ e;
            System.out.println(retorno);
        }
        return retorno;
    }
}
