package edu.cursor.restjackson.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Data
public class WriteUserListToFile {
    public void generateJsonUserList() {
        List<User> users = getRandomUserList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/userList.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> getRandomUserList() {
        Integer accessId = 0;
        List<User> users = new ArrayList<>();
        String[] firstNames = new String[]{"Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter"};
        String[] lastNames = new String[]{"Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler"};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            accessId++;
            int rFirst = random.nextInt(firstNames.length);
            int rLast = random.nextInt(lastNames.length);
            String name = firstNames[rFirst];
            String surname = lastNames[rLast];
            int date = random.nextInt(50) + 1960;
            String email = name + "." + surname + "." + date + "@gmail.com";
            int month = random.nextInt(7) + 1;
            int day = random.nextInt(28) + 1;
            LocalDate lastLoginDate = LocalDate.of(2019, month, day);
            Map<String, Boolean> homeworkToIsDone = new LinkedHashMap<>();
            for (int j = 1; j <= 5; j++) {
                homeworkToIsDone.put("homework-" + j, random.nextBoolean());
            }
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setLastLoginDate(lastLoginDate);
            user.setAccessId(accessId);
            user.setEmail(email);
            user.setHomeworkToIsDone(homeworkToIsDone);
            users.add(user);
        }
        return users;
    }
}
