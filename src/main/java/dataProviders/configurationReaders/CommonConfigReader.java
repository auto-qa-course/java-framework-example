package dataProviders.configurationReaders;

public class CommonConfigReader extends ConfigReader {

    public CommonConfigReader(String configFilePath){ super(configFilePath); }

    public String getHealthCheckPath(){ return this.getProperty("healthCheckPath"); }

    public String getUsersPath(){ return this.getProperty("usersPath"); }
}
