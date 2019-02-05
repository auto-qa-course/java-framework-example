package api;

import dataProviders.configurationReaders.CommonConfigReader;
import static io.restassured.RestAssured.*;
import io.restassured.response.ValidatableResponse;


public class UsersAPI extends BaseAPI {
    public String path;

    public UsersAPI(CommonConfigReader commonConfig) {
        super();
        this.path = commonConfig.getUsersPath();
    }

    public ValidatableResponse postUser(String userBody) {
        return given().
                header("content-type", "application/json").
                body(userBody).
                when().
                post(this.path).
                then();
    }

}


