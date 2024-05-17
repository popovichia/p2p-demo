package ru.baa.p2p.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InConnectionHandler implements Runnable {

    private Socket socket;

    public InConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            try (Socket socket = this.socket; BufferedReader inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                boolean isConnected = true;
                while (isConnected) {
                    while ((message = inReader.readLine()) != null) {
                        System.out.println("Данные получены = " + message);
                        if ("bye".equalsIgnoreCase(message)) {
                            isConnected = false;
                        }
                    }
                }
            }
            System.out.println("Соединение завершено сервером");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
        }
    }
}
