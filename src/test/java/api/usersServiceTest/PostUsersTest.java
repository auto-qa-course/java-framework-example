package api.usersServiceTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class PostUsersTest extends UsersBaseTest {

    public PostUsersTest() { super(); }

    @Test(description = "Test root POST users endpoint.")
    public void TestUsersPost() {
        given().
                header("content-type", "application/json").
                body("{\"name\":\"morpheus\",\"job\":\"leader\"}").
        when().
                post(usersAPI.path).
        then().
                assertThat().statusCode(201).
        extract().
                path("data");
    }

}