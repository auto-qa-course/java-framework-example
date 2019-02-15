package commonLibs.api.users;

import com.github.javafaker.Faker;
import commonLibs.configurationReaders.CommonConfigReader;
import org.testng.annotations.DataProvider;
import java.util.HashMap;

public class UsersData {
    private String testDataNamingPattern;

    public UsersData(CommonConfigReader commonConfig) {
        this.testDataNamingPattern = commonConfig.getTestDataNamingPattern();
    };

    public HashMap<String, String> generateNewUser() {
        Faker faker = new Faker();

        HashMap<String, String> user = new HashMap<>();
        user.put("name", String.format("%s %s", faker.name().firstName(), testDataNamingPattern));
        user.put("job", faker.job().title());
        return user;
    }

    @DataProvider(name = "emptyUser")
    public static Object[][] generateEmptyUser() {
        return new Object[][] { { new HashMap<>() }};
    }
}


