package io.github.williamtrindade.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DATABASE_PATH = "/home/dev4/college/college-project-smart-chess-board/web-app/database/database.sqlite";

    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + DATABASE_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        connect();
    }
}