package apitesting;

import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BaseTest {

    @BeforeSuite()
    public void testSetup() {
        System.out.println("Setup test preconditions.");
    }

    public BaseTest() {
        System.out.println("Let's write some test cases!");

        RestAssured.baseURI = "http://httpbin.org/";

        get("/get").then().assertThat().statusCode(200);

        when().
                get("/get").
        then().
                assertThat().statusCode(200).
                assertThat().body("url", equalTo("http://httpbin.org/get"));

    }

}