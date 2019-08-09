package edu.cursor.restjackson.controller;

import edu.cursor.restjackson.models.User;
import edu.cursor.restjackson.service.UserHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserHandler userHandler;

    @GetMapping(value = "/user/{email}")
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return userHandler.getUserByEmail(email);
    }

    @PostMapping("/user")
    public String receiveUser(@RequestBody User user) {
        return userHandler.receiveUser(user);
    }
}
