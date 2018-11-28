package apitesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.qameta.allure.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@Story("Test Story")
public class BaseTestSuite {

    @Test(description = "Test GET for httpbin.org")
    @Description("Some detailed test description")
    public void BaseTest() {
        RestAssured.baseURI = "http://httpbin.org/";

        when().
                get("/get").
        then().
                assertThat().statusCode(200).
                assertThat().body("url", equalTo("http://httpbin.org/get"));
    }
}