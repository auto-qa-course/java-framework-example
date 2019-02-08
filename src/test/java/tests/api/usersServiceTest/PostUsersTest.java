package tests.api.usersServiceTest;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;

import customLibs.api.UsersData;


@Link(name = "Story 2", value="2", type="backlog_tracker")
@Story("Story 2 'As a system admin I want to be able create users using REST API'" )
public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Issue("3")
    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        HashMap<String, String> userData = UsersData.generateNewUser();

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