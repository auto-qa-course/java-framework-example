package tests.api.usersTest;

import commonLibs.api.users.UsersData;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import java.util.HashMap;


@Link(name = "Story 2", value="2", type="backlog_tracker")
@Story("Story 2 'As a system admin I want to be able create users using REST API'" )
public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint with empty body.")
    public void TestUsersPostEmptyBody() {
        ValidatableResponse response = usersAPI.postUserNoResponseCodeValidation(UsersData.generateEmptyUser());

        response.assertThat().statusCode(usersAPI.BAD_REQUEST_CODE);
    }

    @Test(description = "Test root POST users & GET by id.")
    public void TestUsersPostGetByID() {
        HashMap<String, String> userData = usersData.generateNewUser();

        ValidatableResponse postUserResponse = usersAPI.postUser(userData);

        String userId = usersAPI.parseIdFromResponse(postUserResponse);

        ValidatableResponse getUserResponse = usersAPI.getUserById(userId);

        usersAPI.assertUserBody(getUserResponse, userData);
    }

    @Test(description = "Test root POST users endpoint & verify body.")
    public void TestUsersPostVerifyBody() {
        HashMap<String, String> userData = usersData.generateNewUser();

        ValidatableResponse response = usersAPI.postUser(userData);

        usersAPI.assertUserBody(response, userData);
    }
}