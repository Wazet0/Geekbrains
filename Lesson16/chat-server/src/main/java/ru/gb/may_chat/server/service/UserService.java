package ru.gb.may_chat.server.service;

import ru.gb.may_chat.server.model.User;

public interface UserService {
    void start();
    void stop();
    String authenticate(String login, String password);
    String changeNick(String login, String newNick);
    User createUser(String login, String password, String nick);
    void deleteUser(String login, String password);
    void changePassword(String login, String oldPassword, String newPassword);
}
