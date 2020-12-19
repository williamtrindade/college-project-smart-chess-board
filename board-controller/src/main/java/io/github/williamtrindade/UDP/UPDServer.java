package io.github.williamtrindade.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@SuppressWarnings("InfiniteLoopStatement")
public class UPDServer {
    public static void main(String[] args) throws IOException {

        // Create socket
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        byte[] sendData;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

            // Receive Chess Notation
            String notation = receivePacket(serverSocket, receivePacket);

            // Receive IP Address
            InetAddress IPAddress = receivePacket.getAddress();

            // Receive Port
            int port = receivePacket.getPort();

            String response = "OK";
            sendData = response.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private static String receivePacket(DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException {
        serverSocket.receive(receivePacket);
        return new String(receivePacket.getData());
    }
}
