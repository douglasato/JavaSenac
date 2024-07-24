import java.sql.*;

public class InserirRegistro {
    public static String cadastrar(String db, String tbl, String campo, String nome) {
        String retorno = "nada aconteceu ainda...";
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlInserirRegistro = "insert into `"+ db + "`.`"+ tbl + "` (`" + campo + "`) values (`" + nome + "`);";
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
