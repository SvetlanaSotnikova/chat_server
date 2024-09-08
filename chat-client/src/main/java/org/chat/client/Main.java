package org.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            Socket socket = new Socket("localhost", 1010);
            Client client = new Client(socket, name);
            InetAddress address = socket.getInetAddress();
            System.out.println("Inet address: " + address);
            String remoteIP = address.getHostAddress();
            System.out.println("Remote IP: " + remoteIP);
            System.out.println("LocalPost: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
