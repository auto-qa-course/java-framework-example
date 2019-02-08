package customLibs.api;

import java.util.HashMap;
import com.github.javafaker.Faker;

public class UsersData {
    public UsersData() {};

    public static HashMap<String, String> generateNewUser() {
        Faker faker = new Faker();

        HashMap<String, String> user = new HashMap<>();
        user.put("name", faker.name().firstName());
        user.put("job", "QA");
        return user;
    }
}
