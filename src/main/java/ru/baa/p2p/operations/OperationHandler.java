package ru.baa.p2p.operations;

import ru.baa.p2p.connections.OutConnection;

import java.util.Scanner;

public class OperationHandler implements Runnable {

    private OutConnection outConnection;

    public OperationHandler(OutConnection outConnection) {
        this.outConnection = outConnection;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            String operation = scanner.nextLine();
            if (operation.toLowerCase().startsWith("send ")) {
                String[] text = operation.split(" ");
                outConnection.send(text[1]);
            } else if ("bye".equals(operation.toLowerCase())) {
                isRunning = false;
                outConnection.send("bye");
                scanner.close();
            }
        }
    }
}
