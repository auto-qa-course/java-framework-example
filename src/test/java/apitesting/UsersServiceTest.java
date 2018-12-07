package apitesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.qameta.allure.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

@Story("Test /users service endpoints")
public class UsersServiceTest {

    @BeforeClass
    public void SetupBaseURL() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test(description = "Test root GET users endpoint.")
    public void TestUsersGet() {
        when().
                get("/users").
        then().
                assertThat().statusCode(200);
    }

    @Test(description = "Test GET Users pagination - page parameter.")
    public void TestUsersGetPaginationByPageNumber() {
        Integer page_number = 1;
        when().
                get(String.format("/users?page=%s", page_number)).
        then().
                assertThat().statusCode(200).
                assertThat().body("page", equalTo(page_number));
    }

    @Test(description = "Test GET Users pagination.")
    public void TestUsersGetPaginationPerPageSize() {
        Integer page_size = 10;
        ArrayList<String> response =
                when().
                get(String.format("/users?per_page=%s", page_size)).
        then().
                assertThat().statusCode(200).
        extract().
                  path("data");
        System.out.println(response);
    }
}