package org.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1010);
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (
                UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
