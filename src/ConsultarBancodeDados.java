import java.sql.*;

public class ConsultarBancodeDados {
    public static void main(String[] args) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisaRegistro = "select * from where `db_teste`.`tbl_teste` where 'nome' = 'Teste';";
            Statement stmSqlPesquisaRegistro = conexao.createStatement();
            ResultSet resultado = stmSqlPesquisaRegistro.executeQuery(stmSqlPesquisaRegistro);

            while(resultado.next()){
                System.out.println(resultado.getString ("email"));
            }
            System.out.println("Pesquisa realizada com sucesso");
        } catch (Exception e) {
          System.out.println("Ocorreu um erro na consulta: "+ e);        
        }
    }
}
