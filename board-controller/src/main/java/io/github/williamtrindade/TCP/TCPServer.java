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

        // output string
        String outputString = "";

        while (true) {
            // Connection Socket
            Socket connectionSocket = welcomeSocket.accept();

            // Cadeia de entrada
            BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            // Cadeia de saída
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // received string
            String receivedString = inFromClient.readLine();
            int opCode = Integer.parseInt(receivedString.split(" ")[0].trim());
            if (opCode == Match.OP_CODE_WINNER) {
                Match.saveWinnerToDatabase(receivedString);
                outputString = "WINNER SAVED";
            }
            if (opCode == Match.OP_CODE_MOVE) {
                Move.saveMoveToDatabase(receivedString);
                outputString = "MOVEMENT SAVED";
            }

            outToClient.writeBytes(outputString + '\n');
        }
    }
}
