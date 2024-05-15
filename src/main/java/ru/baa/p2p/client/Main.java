package ru.baa.p2p.client;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 5500);
        Thread.startVirtualThread(new ClientConnection(socket));
        while (true) {

        }
    }
}