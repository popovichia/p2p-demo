package ru.baa.p2p.server;

import ru.baa.p2p.connections.InConnectionHandler;
import ru.baa.p2p.connections.OutConnection;
import ru.baa.p2p.operations.OperationHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 5500));
        while (true) {
            System.out.println("Ожидаем соединение");
            Socket socket = serverSocket.accept();
            Thread.startVirtualThread(new InConnectionHandler(socket));
            Thread.startVirtualThread(new OperationHandler(new OutConnection(socket)));
            System.out.println("Соединение установлено");
        }
    }
}