package commonLibs.api;
import commonLibs.configurationReaders.CommonConfigReader;
import commonLibs.utils.AllureStepLogger;
import commonLibs.utils.SimpleLogger;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class BaseAPI {
    public final Integer CREATED_CODE = 201;
    public final Integer SUCCESS_CODE = 200;
    public final Integer BAD_REQUEST_CODE = 201;
    private SimpleLogger logger;

    public BaseAPI(CommonConfigReader commonConfig, SimpleLogger logger) {
        this.logger = logger;
    };

    protected ValidatableResponse sendPost(String requestPath, HashMap<String, String> requestHeaders, HashMap requestBody) {
        final String SEND_MESSAGE = "Sending POST %s, HEADERS: %s,  BODY %s ";
        final String RECEIVED_MESSAGE = "Received code: %s, BODY: %s";

        logger.log(String.format(SEND_MESSAGE, requestPath, requestHeaders, requestBody));

        ValidatableResponse response = given().headers(requestHeaders).body(requestBody).
                when().post(requestPath).
                then();

        logger.log(String.format(RECEIVED_MESSAGE,
                this.parseResponseCode(response),
                this.parseResponseBody(response)));

        return response;
    }

    protected ValidatableResponse sendGet(String requestPath, HashMap<String, String> requestHeaders) {
        final String SEND_MESSAGE = "Sending POST %s, HEADERS: %s ";
        final String RECEIVED_MESSAGE = "Received code: %s, BODY: %s";

        logger.log(String.format(SEND_MESSAGE, requestPath, requestHeaders));

        ValidatableResponse response = given().headers(requestHeaders).
                when().get(requestPath).
                then();

        logger.log(String.format(RECEIVED_MESSAGE,
                this.parseResponseCode(response),
                this.parseResponseBody(response)));

        return response;
    }

    protected ValidatableResponse sendPostStepLogging(String requestPath, HashMap<String, String> requestHeaders, HashMap requestBody) {
        final String SEND_MESSAGE = "Sending POST %s, HEADERS: %s  BODY %s ";
        final String RECEIVED_MESSAGE = "Received code: %s, BODY: %s";

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

