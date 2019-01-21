package api.usersServiceTest;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        given().
                formParam("name", "morpheus").
                formParam("job", "leader").
        when().
                post(usersAPI.path).
        then().
                assertThat().statusCode(201);
    }

}