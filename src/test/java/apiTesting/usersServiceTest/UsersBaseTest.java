package apiTesting.usersServiceTest;

import apiTesting.BaseTest;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;


public class UsersBaseTest extends BaseTest {

    @BeforeClass
    public void SetupBaseURL() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    UsersBaseTest() { super(); }
}