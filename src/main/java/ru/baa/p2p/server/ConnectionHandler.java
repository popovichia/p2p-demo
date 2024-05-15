package ru.baa.p2p.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    private Socket socket;
    private BufferedReader fromClientReader;
    private OutputStream toClientStream;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            this.fromClientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.toClientStream = socket.getOutputStream();
            String data;
            System.out.println("Клиент подключился");
            while (true) {
                while ((data = fromClientReader.readLine()) != null) {
                    System.out.println("Данные получены от клиента = " + data);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
        }
    }
}
