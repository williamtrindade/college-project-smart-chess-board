package io.github.williamtrindade.DAO;

import io.github.williamtrindade.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoveDAO {
    public void create(String white, String black, Integer matchId) throws SQLException {
        Connection connection = ConnectionDB.connect();
        assert connection != null;
        String sql = "INSERT INTO moves (white, black, chess_match_id, created_at, updated_at) VALUES(?, ?, ?, NULL, NULL);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, white);
        preparedStatement.setString(2, black);
        preparedStatement.setInt(3, matchId);
        preparedStatement.execute();
    }
}
