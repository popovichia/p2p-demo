package ru.baa.p2p.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 5500));
        while (true) {
            System.out.println("Ожидаем подключение клиента");
            Thread.startVirtualThread(new ConnectionHandler(serverSocket.accept()));
        }
    }
}