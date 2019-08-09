package edu.cursor.restjackson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cursor.restjackson.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class UserHandlerImpl implements UserHandler {

    private static final String TEST_FILE_PATH = "target/output.json";
    private static Integer INITIAL_LOGIN_ID = 0;
    private ObjectMapper shortDateObjectMapper;
    private List<User> users;

    @Override
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public String receiveUser(User user) {
        String answer = "User " + user.getName() + " " + user.getSurname() + " is saved in output.json file!";
        user.setAccessId(INITIAL_LOGIN_ID++);

        try {
            shortDateObjectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(TEST_FILE_PATH), user);
        } catch (IOException e) {
            e.printStackTrace();
            answer = "Inner server IOException!";
        }
        return answer;
    }
}
