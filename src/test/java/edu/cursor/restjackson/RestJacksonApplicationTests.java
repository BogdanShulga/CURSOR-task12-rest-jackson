package edu.cursor.restjackson;

import edu.cursor.restjackson.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestJacksonApplicationTests {
    private RestTemplate restTemplate;
    private static final String USER_URL = "http://localhost:8080/user";
    private List<User> users;
    private Random random = new Random();

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Test
    public void getUserByEmailTest() {
        int usersSize = users.size();
        System.out.println("From test" + users);
        User randomUser = users.get(random.nextInt(usersSize));
        String url = USER_URL + "/" + randomUser.getEmail();

        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);

        assertEquals(randomUser, responseEntity.getBody());
    }

    @Test
    public void userSaveToFileTest() {
        int usersSize = users.size();
        User randomUser = users.get(random.nextInt(usersSize));
        String expectedResponse = "User " + randomUser.getName() + " " + randomUser.getSurname() + " is saved in output.json file!";

        HttpEntity<User> requestBody = new HttpEntity<>(randomUser);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(USER_URL, requestBody, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}
