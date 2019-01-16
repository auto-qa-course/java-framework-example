package dataProviders.configurationReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


class ConfigReader {

    private Properties configuration;
    private String configFilePath;

    ConfigReader(String configFilePath) {
        Properties configuration = new Properties();
        this.configFilePath = configFilePath;
        try {
            InputStream input = new FileInputStream(configFilePath);
            try {
                configuration.load(input);
                this.configuration = configuration;
            } catch (IOException exception) {
                exception.printStackTrace();
                throw new RuntimeException(String.format("Configuration %s cannot be loaded.", configFilePath));
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            throw new RuntimeException(String.format("File %s not found.", configFilePath));
        }
    }

    String getProperty(String propertyName){
        String propertyValue = configuration.getProperty(propertyName);
        if(propertyValue!= null) return propertyValue;
        else {
            throw new RuntimeException(String.format("%s not specified in the %s file.", propertyName, configFilePath));
        }
    }
}

