package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao implements IConst {
    public static Connection getConexao(String stringDeConexao, String usuario, String senha) {
        try {
            return DriverManager.getConnection(stringDeConexao, "postgres", "482593");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}