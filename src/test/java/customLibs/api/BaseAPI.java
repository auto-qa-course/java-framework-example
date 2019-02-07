package customLibs.api;
import customLibs.utils.AllureStepLogger;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

class BaseAPI {
    public final Integer CREATED_CODE = 201;

    BaseAPI() {};

    ValidatableResponse sendPost(String requestPath, HashMap<String, String> requestHeaders, HashMap requestBody) {
        final String SEND_MESSAGE = "LOG: Sending POST %s, HEADERS: %s  BODY %s ";
        final String RECEIVED_MESSAGE = "LOG: Received code: %s, BODY: %s";

        AllureStepLogger.log(String.format(SEND_MESSAGE, requestPath, requestHeaders, requestBody));

        ValidatableResponse response = given().headers(requestHeaders).body(requestBody).
                when().post(requestPath).
                then();

        AllureStepLogger.log(String.format(RECEIVED_MESSAGE,
                this.parseResponseCode(response),
                this.parseResponseBody(response)));

        return response;
    }

    public Integer parseResponseCode(ValidatableResponse response){
        return response.extract().statusCode();
    }

    public String parseResponseBody(ValidatableResponse response){
        return response.extract().path("").toString();
    }
}

