package api;

import dataProviders.configurationReaders.CommonConfigReader;

public class UsersAPI {
    public String path;

    public UsersAPI(CommonConfigReader commonConfig) {
        this.path = commonConfig.getUsersPath();
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
