package dataProviders.configurationReaders;

public class EnvironmentConfigReader extends ConfigReader {

    public EnvironmentConfigReader(String configFilePath){ super(configFilePath); }

    public String getMainServiceURL(){ return this.getProperty("baseUrl"); }

    public String getUserName(){ return this.getProperty("testUserName"); }

    public String getUserPassword(){ return this.getProperty("testUserPassword"); }

}
