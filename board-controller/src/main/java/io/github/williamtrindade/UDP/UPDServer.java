package io.github.williamtrindade.UDP;

import io.github.williamtrindade.DAO.MoveDAO;
import io.github.williamtrindade.Models.Match;
import io.github.williamtrindade.Models.Move;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLException;

@SuppressWarnings("InfiniteLoopStatement")
public class UPDServer {
    public static void main(String[] args) throws IOException {

        // Create socket
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        byte[] sendData;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive Chess Notation
            String moveString = receivePacket(serverSocket, receivePacket);
            Move move = new Match().getMoveFromString(moveString);

            // Save to database
            sendData = "MOVEMENT SAVED".getBytes();
            try {
                MoveDAO moveDAO = new MoveDAO();
                moveDAO.create(move.getWhite(), move.getBlack(), move.getChessMatchId());
            } catch (SQLException e) {
                e.printStackTrace();
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
