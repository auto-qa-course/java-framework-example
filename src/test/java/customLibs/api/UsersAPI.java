package customLibs.api;

import dataProviders.configurationReaders.CommonConfigReader;
import static io.restassured.RestAssured.*;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.Step;


public class UsersAPI extends BaseAPI {
    public String path;

    public UsersAPI(CommonConfigReader commonConfig) {
        super();
        this.path = commonConfig.getUsersPath();
    }

    @Step("POST user")
    public ValidatableResponse postUser(String userBody) {
        return given().
                header("content-type", "application/json").
                body(userBody).
                when().
                post(this.path).
                then();
    }

    public String getUsersByPagePath(Integer pageNumber) {
        return String.format("%s?page=%s", this.path, pageNumber);
    }

    public String getUsersByPagePerPageSizePath(Integer pageNumber,Integer pageSize) {
        return String.format("%s?page=%s&per_page=%s", this.path, pageNumber, pageSize);
    }

    public String getUsersBySizePath(Integer pageSize) {
        return String.format("%s?size=%s", this.path, pageSize);
    }
}


