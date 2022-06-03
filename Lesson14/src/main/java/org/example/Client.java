package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{
    private static final String HOST = "127.0.0.1";

    private static final int PORT = 8080;

    Socket[] sockets = new Socket[10];
    int iterID;

    @Override
    public void run(){
        for(iterID = 0; iterID < 10; iterID++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        serverManage();
                    } catch (IOException  | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void serverManage() throws IOException, InterruptedException {
        sockets[iterID] = new Socket(HOST, PORT);
        Socket s = sockets[iterID];
        int currentId = iterID;

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        //Нижняя строчка это будет служебное сообщение. Типо авторизация.
        out.writeUTF("" + iterID);


        out.writeUTF("Hello!");

        while(true){
            //Тут должен быть сканнер для ввода сообщений. Но в эмуляции 10 клиентов будет трудно вводить.
            //Что-то типо такого
            //Scanner scanner = new Scanner(System.in);
            //String message = scanner.nextLine();
            String message = in.readUTF();
            System.out.println("I am ID " + currentId + " and i get message: " + message);
        }
    }
}
