package dataProviders.configurationReaders;

public class EnvironmentConfigReader extends ConfigReader {

    public EnvironmentConfigReader(String configFilePath){
        super(configFilePath);
    }

    public String getMainServiceURL(){
        String serviceURL = configuration.getProperty("baseUrl");
        if(serviceURL!= null) return serviceURL;
        else throw new RuntimeException(String.format("baseUrl not specified in the %s file.", configFilePath));
    }
}
