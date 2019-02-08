package customLibs.configurationReaders;

public class CommonConfigReader extends ConfigReader {

    public CommonConfigReader(String configFilePath){
        super(configFilePath);
    }

    public String getUsersPath(){
        return this.getProperty("usersPath");
    }
}
