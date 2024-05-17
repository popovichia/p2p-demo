package ru.baa.p2p.connections;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class OutConnection {

    private Socket socket;
    private PrintWriter outWriter;

    public OutConnection(Socket socket) {
        this.socket = socket;
    }


    public void send(String message) {
        try {
            this.outWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("Отправка сообщения = " + message);
            outWriter.println(message);
            outWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
