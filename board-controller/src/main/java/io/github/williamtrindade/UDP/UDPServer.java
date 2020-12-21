package io.github.williamtrindade.UDP;

import io.github.williamtrindade.Models.Match;
import io.github.williamtrindade.Models.Move;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@SuppressWarnings("InfiniteLoopStatement")
public class UDPServer {
    public static void main(String[] args) throws IOException {

        // Create socket
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive Chess Notation
            String receivedString = receivePacket(serverSocket, receivePacket);
            int opCode = Integer.parseInt(receivedString.split(" ")[0].trim());
            if (opCode == Match.OP_CODE_WINNER) {
                Match.saveWinnerToDatabase(receivedString);
                sendData = "WINNER SAVED".getBytes();
            }
            if (opCode == Match.OP_CODE_MOVE) {
                Move.saveMoveToDatabase(receivedString);
                sendData = "MOVEMENT SAVED".getBytes();
            }

            // Receive IP Address
            InetAddress IPAddress = receivePacket.getAddress();

            // Receive Port
            int port = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private static String receivePacket(DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException {
        serverSocket.receive(receivePacket);
        return new String(receivePacket.getData());
    }
}
