package edu.cursor.restjackson;

import edu.cursor.restjackson.models.WriteUserListToFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestJacksonApplication {

    public static void main(String[] args) {
        new WriteUserListToFile().generateJsonUserList();
        SpringApplication.run(RestJacksonApplication.class, args);
    }
}
