package io.github.williamtrindade.Models;

import io.github.williamtrindade.DAO.MatchDAO;
import io.github.williamtrindade.DAO.MoveDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Match {
    public static final Integer OP_CODE_WINNER = 1;
    public static final Integer OP_CODE_MOVE = 2;

    public static final Integer WHITE = 1;
    public static final Integer BLACK = 2;

    public static String readNotation() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }

    public static Move getMoveFromString(String move) {
        String[] input = move.split(" ");
        String white = input[1].trim();
        String black = input[2].trim();
        int matchId = parseInt(input[3].trim());
        return new Move(white, black, matchId);
    }

    public static void saveWinnerToDatabase(String receivedString) {
        String[] receivedArray = receivedString.split(" ");
        int match_id = Integer.parseInt(receivedArray[1].trim());
        int winnerColor = Integer.parseInt(receivedArray[2].trim());
        // Save to database
        try {
            MatchDAO matchDAO = new MatchDAO();
            matchDAO.declareWinner(match_id, winnerColor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
