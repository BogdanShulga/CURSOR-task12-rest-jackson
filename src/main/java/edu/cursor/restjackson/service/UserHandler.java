package edu.cursor.restjackson.service;

import edu.cursor.restjackson.models.User;

public interface UserHandler {
    User getUserByEmail(String email);
    String receiveUser(User user);
}
