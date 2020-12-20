package io.github.williamtrindade.DAO;

import io.github.williamtrindade.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class MatchDAO {

    public void declareWinner(Integer matchId, Integer winnerColor) throws SQLException {
        Connection connection = ConnectionDB.connect();
        assert connection != null;
        String sql = "UPDATE chess_matches SET winner=?, updated_at=? WHERE id=?;";

        Calendar calendar = Calendar.getInstance();
        java.util.Date currentTime = calendar.getTime();
        long time = currentTime.getTime();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, winnerColor);
        preparedStatement.setTimestamp(2, new Timestamp(time));
        preparedStatement.setInt(3, matchId);
        preparedStatement.executeUpdate();
    }
}
