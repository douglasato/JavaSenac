import java.sql.*;

public class InserirRegistro {
    public static void main(String[] args) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlStringTabela = "insert into `db_teste`.`tbl_teste` (`nome`, `email`, `senha`) values ('Teste', 'testeteste.teste', 'senhaTeste');";
            // ('nome', 'email', 'senha') values(\'Teste', \'testeteste.teste\', \'senhaTeste\')
            Statement stmSqlInserirRegistro = conexao.createStatement();
            stmSqlInserirRegistro.addBatch(strSqlStringTabela);
            stmSqlInserirRegistro.executeBatch();
            stmSqlInserirRegistro.close();
            System.out.println("Registro inserido com sucesso");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: "+ e);
        }
    }
}
