package edu.cursor.restjackson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.cursor.restjackson.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserHandlerImpl implements UserHandler {

    List<User> users;

    private static final String TEST_FILE_PATH = "target/output.json";
    private static Integer INITIAL_LOGIN_ID = 0;

    @Override
    public List<User> getUserList() {
        return users;
    }

    @Override
    public void receiveUser(User user) {
        user.setAccessId(INITIAL_LOGIN_ID++);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(TEST_FILE_PATH), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
