package io.github.williamtrindade.TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence = inFromUser.readLine();

        Socket clientSocket = new Socket("localhost",6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(sentence + '\n');
        String modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
