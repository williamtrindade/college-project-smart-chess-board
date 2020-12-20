package io.github.williamtrindade.TCP;

import io.github.williamtrindade.DAO.MoveDAO;
import io.github.williamtrindade.Models.Match;
import io.github.williamtrindade.Models.Move;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

@SuppressWarnings("InfiniteLoopStatement")
public class TCPServer {
    public static void main(String[] args) throws IOException {
        // Welcome socket
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            // Connection Socket
            Socket connectionSocket = welcomeSocket.accept();

            // Cadeia de entrada
            BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            // Cadeia de saída
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // Get Move from client
            Move move = new Match().getMoveFromString(inFromClient.readLine());

            // Save to database
            try {
                MoveDAO moveDAO = new MoveDAO();
                moveDAO.create(move.getWhite(), move.getBlack(), move.getChessMatchId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            outToClient.writeBytes("MOVEMENT SAVED" + '\n');
        }
    }
}
