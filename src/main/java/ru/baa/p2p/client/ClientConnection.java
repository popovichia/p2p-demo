package ru.baa.p2p.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

public class ClientConnection implements Runnable {

    private UUID clientUuid = UUID.randomUUID();
    private Socket socket;
    private BufferedReader inReader;
    private PrintWriter outWriter;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        try {
            this.inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Клиент запущен");
        String message;
        try {
            while (true) {
                Thread.sleep(1_000L);
                message = "TEST_" + clientUuid + "_" + System.currentTimeMillis();
                System.out.println("Отправка сообщения = " + message);
                outWriter.println(message);
                outWriter.flush();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
