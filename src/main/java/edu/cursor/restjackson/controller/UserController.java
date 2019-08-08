package edu.cursor.restjackson.controller;

import edu.cursor.restjackson.models.User;
import edu.cursor.restjackson.service.UserHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserHandler userHandler;

    @PostMapping("/user")
    public String receiveUser(@RequestBody User user) {
        return userHandler.receiveUser(user);
    }
}
