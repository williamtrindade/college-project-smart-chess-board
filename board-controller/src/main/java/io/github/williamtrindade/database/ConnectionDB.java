package io.github.williamtrindade.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection getConexao() throws ClassNotFoundException {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url ="jdbc:postgresql://localhost:5432/db_programacao_web";
            String user="postgres";
            String password = "";
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

}