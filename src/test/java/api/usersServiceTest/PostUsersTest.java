package api.usersServiceTest;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        String user_data = "{\"name\":\"Joe\",\"job\":\"QA\"}";
        ArrayList<String> response =
                given().
                    header("content-type", "application/json").
                    body(user_data).
                when().
                    post(usersAPI.path).
                then().
                    assertThat().statusCode(201).
                extract().
                    path("data");
    }
}