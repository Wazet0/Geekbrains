package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server implements Runnable{
    private static final int PORT = 8080;
    private static final HashMap<Integer, Socket> users = new HashMap<>();

    @Override
    public void run(){
        try {
            ServerSocket server = new ServerSocket(PORT);
            for(int cons = 0; cons < 10; cons++) {
                Socket socket = server.accept();
                System.out.println("New connection");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clientManage(socket);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clientManage(Socket socket) throws IOException, InterruptedException {
        DataInputStream in = new DataInputStream(socket.getInputStream());

        String id = in.readUTF();
        users.put(Integer.valueOf(id), socket);

        while(true){
            String message = in.readUTF();
            for(int i = 0; i < users.size(); i++){
                Socket user = users.get(i);
                if(!(i == Integer.parseInt(id) && user.isClosed())){
                    DataOutputStream userOut = new DataOutputStream(user.getOutputStream());
                    userOut.writeUTF("ID " + id + " say: " + message);
                    userOut.flush();
                }
            }
        }
    }
}
