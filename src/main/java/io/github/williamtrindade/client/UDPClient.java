package io.github.williamtrindade.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author William Trindade<williamtrindade.contato@gmail.com>
 */
class UDPClient {
    public static void main(String[] args) throws IOException {

        // Get Data to send
        byte[] sendData = readNotation().getBytes();

        // Create Socket
        DatagramSocket clientSocket = new DatagramSocket();

        // Get IP Address
        InetAddress IPAddress = InetAddress.getByName("localhost");

        // Send Datagrama to server
        sendPacket(clientSocket, sendData, IPAddress);

        // Receive Datagrama from server
        String status = receivePacket(clientSocket);

        System.out.println("STATUS:" + status);
        clientSocket.close();

    }

    private static String receivePacket(DatagramSocket clientSocket) throws IOException {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        return new String(receivePacket.getData());
    }

    private static void sendPacket(DatagramSocket clientSocket, byte[] sendData, InetAddress IPAddress) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
    }

    private static String readNotation() throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        return inFromUser.readLine();
    }

}