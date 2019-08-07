package edu.cursor.restjackson.service;

import edu.cursor.restjackson.models.User;

import java.util.List;

public interface UserHandler {
    List<User> getUserList();
    void receiveUser(User user);
}
