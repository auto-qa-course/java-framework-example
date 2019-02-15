package commonLibs.api.users;

import commonLibs.api.BaseAPI;
import commonLibs.configurationReaders.CommonConfigReader;
import commonLibs.utils.SimpleLogger;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.Step;
import java.util.HashMap;

public class UsersAPI extends BaseAPI {
    private String path;
    private HashMap<String, String> requestHeaders;

    public UsersAPI(CommonConfigReader commonConfig, SimpleLogger logger) {
        super(commonConfig, logger);
        this.path = commonConfig.getUsersPath();
        this.requestHeaders = this.setDefaultHeaders();
    }

    private HashMap<String, String> setDefaultHeaders(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        return headers;
    }

    @Step("POST user")
    public ValidatableResponse postUser(HashMap userBody) {
        return this.sendPost(this.path, this.requestHeaders, userBody);
    }

    @Step("GET users list")
    public ValidatableResponse getUsers() {
        return this.sendGet(this.path, this.requestHeaders);
    }

    @Step("GET users list by page")
    public ValidatableResponse getUsersByPage(int pageNumber) {
        return this.sendGet(this.getUsersByPagePath(pageNumber), this.requestHeaders);
    }

    @Step("GET users list by size")
    public ValidatableResponse getUsersBySize(int pageSize) {
        return this.sendGet(this.getUsersBySizePath(pageSize), this.requestHeaders);
    }

    @Step("GET users list by page & size")
    public ValidatableResponse getUsersByPagePerPageSize(int pageNumber, int pageSize) {
        return this.sendGet(this.getUsersByPagePerPageSizePath(pageNumber, pageSize), this.requestHeaders);
    }

    @Step("Parse total pages from response")
    public int parseTotalPagesFromResponse(ValidatableResponse response){
        return response.
                assertThat().statusCode(this.SUCCESS_CODE).
                extract().
                path("total_pages");
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


