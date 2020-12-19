package io.github.williamtrindade.TCP;

import io.github.williamtrindade.Models.Match;
import io.github.williamtrindade.Models.Move;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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

            // Get String from client
            Move move = new Match().getMoveFromString(inFromClient.readLine());
            System.out.println(move.getChessMatchId());
            System.out.println(move.getWhite());

            outToClient.writeBytes("sasa" + '\n');
        }
    }
}
