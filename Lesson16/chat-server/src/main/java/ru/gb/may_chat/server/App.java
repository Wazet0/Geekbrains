package ru.gb.may_chat.server;

import ru.gb.may_chat.server.service.impl.InMemoryUserServiceImpl;

public class App {
    public static void main(String[] args) {
        new Server(new InMemoryUserServiceImpl()).start();
    }
}
