package edu.cursor.restjackson.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate lastLoginDate;
    @JsonIgnore
    private Integer accessId;
    private String email;
    private Map<String, Boolean> homeworkToIsDone;
}
