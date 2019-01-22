package api.usersServiceTest;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        String userData = "{\"name\":\"Joe\",\"job\":\"QA\"}";
        String userId =
                given().
                    header("content-type", "application/json").
                    body(userData).
                when().
                    post(usersAPI.path).
                then().
                    assertThat().statusCode(201).
                        assertThat().body("name", equalTo("Joe")).
                        assertThat().body("job", equalTo("QA")).
                extract().
                    path("id");
        System.out.println(userId);
    }
}