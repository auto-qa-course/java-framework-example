package tests.api.usersServiceTest;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "Joe");
        userData.put("job", "QA");

        ValidatableResponse response = usersAPI.postUser(userData);

        response.assertThat().statusCode(usersAPI.CREATED_CODE);
    }

    @Test(description = "Test root POST users endpoint & get id.")
    public void TestUsersPostGetID() {

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "Joe");
        userData.put("job", "QA");

        ValidatableResponse response = usersAPI.postUser(userData);
        String userId = response.assertThat().statusCode(usersAPI.CREATED_CODE).
                assertThat().body("name", equalTo("Joe")).
                assertThat().body("job", equalTo("QA")).
                extract().
                path("id");
        System.out.println(userId);
    }
}