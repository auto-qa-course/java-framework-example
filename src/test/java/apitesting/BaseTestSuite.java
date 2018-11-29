package apitesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.qameta.allure.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@Story("Test Story")
public class BaseTestSuite {

    @BeforeClass
    public void SetupBaseURL() {
        RestAssured.baseURI = "http://httpbin.org/";
    }

    @Test(description = "Test /get endpoint.")
    public void TestRootGet() {
        when().
                get("/get").
        then().
                assertThat().statusCode(200).
                assertThat().body("url", equalTo("http://httpbin.org/get"));
    }

    @Test(description = "Test /cookies endpoint.")
    public void TestCookies() {

        String response = get("/cookies").asString();
        System.out.println(response);

        response = given().header("accept", "text/plain")
                .get("/cookies/set/{key}/{value}", "new_key", "new_value").asString();
        System.out.println(response);
    }
}