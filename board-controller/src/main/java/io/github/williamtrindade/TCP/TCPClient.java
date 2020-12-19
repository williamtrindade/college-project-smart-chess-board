package io.github.williamtrindade.TCP;

import io.github.williamtrindade.Models.Match;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        
        // Serialize input to bytes
        String sendData = Match.readNotation();
        
        // Create socket
        Socket clientSocket = new Socket("localhost",6789);
        
        // Send to server
        sendPacket(clientSocket, sendData);

        // Receive Data from server
        String status = receivePacket(clientSocket);

        System.out.println("STATUS: " + status);
        clientSocket.close();
    }

    private static String receivePacket(Socket clientSocket) throws IOException {
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        return inFromServer.readLine();
    }

    private static void sendPacket(Socket clientSocket, String sendData) throws IOException {
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(sendData + '\n');
    }
}
