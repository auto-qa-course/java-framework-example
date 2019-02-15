package commonLibs.configurationReaders;

public class CommonConfigReader extends ConfigReader {

    public CommonConfigReader(String configFilePath){
        super(configFilePath);
    }

    public String getUsersPath(){
        return this.getProperty("usersPath");
    }

    public String getTestDataNamingPattern(){
        return this.getProperty("testDataNamingPattern");
    }
}
