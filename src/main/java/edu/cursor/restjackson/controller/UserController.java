package edu.cursor.restjackson.controller;

import edu.cursor.restjackson.models.User;
import edu.cursor.restjackson.service.UserHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserHandler userHandler;

    @GetMapping("/getusers")
    public List<User> getUserList() {
        return userHandler.getUserList();
    }

    @PostMapping("/user")
    public void receiveUser(@RequestBody User user) {
        userHandler.receiveUser(user);
    }
}
