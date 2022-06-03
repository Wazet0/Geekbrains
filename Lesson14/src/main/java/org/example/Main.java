package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Thread server = new Thread(new Server());
        Thread client = new Thread(new Client());

        server.start();
        client.start();

        try{
            server.join();
            client.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
