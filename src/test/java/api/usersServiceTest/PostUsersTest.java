package api.usersServiceTest;

import org.testng.annotations.Test;

import java.util.ArrayList;

import com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import com.jayway.restassured.response.ValidatableResponse;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        String userData = "{\"name\":\"Joe\",\"job\":\"QA\"}";
        ValidatableResponse userResponse = usersAPI.getNewUserId(userData);
        String userId = userResponse.
                assertThat().statusCode(201).
                assertThat().body("name", equalTo("Joe")).
                assertThat().body("job", equalTo("QA")).
                extract().
                    path("id");
        System.out.println(userId);
    }
}