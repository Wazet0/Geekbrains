package ru.gb.may_chat.client.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkService {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8189;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Thread clientThread;
    private final MessageProcessor messageProcessor;

    public NetworkService(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    public void connect() throws IOException {
        socket = new Socket(HOST, PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        readMessages();
    }

    private void readMessages() {
        clientThread = new Thread(() -> {
            try {
                while (!socket.isClosed() && !Thread.currentThread().isInterrupted()) {
                    String income = in.readUTF();
                    System.out.println("Got income message");
                    messageProcessor.processMessage(income);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    shutdown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        clientThread.start();
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }

    public void shutdown() throws IOException {
        if (clientThread != null && clientThread.isAlive()) {
            clientThread.interrupt();
        }
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
        System.out.println("Client stopped");
    }

}
