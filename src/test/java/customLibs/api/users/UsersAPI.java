package customLibs.api.users;

import customLibs.api.BaseAPI;
import dataProviders.configurationReaders.CommonConfigReader;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.Step;
import java.util.HashMap;

public class UsersAPI extends BaseAPI {
    public String path;

    public UsersAPI(CommonConfigReader commonConfig) {
        super();
        this.path = commonConfig.getUsersPath();
    }

    @Step("POST user")
    public ValidatableResponse postUser(HashMap userBody) {
        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("content-type", "application/json");

        return this.sendPost(this.path, requestHeaders, userBody);
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

