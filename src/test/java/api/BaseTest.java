package api;

import dataProviders.configurationReaders.EnvironmentConfigReader;
import dataProviders.configurationReaders.CommonConfigReader;

public class BaseTest {
    private String envName = System.getProperty("environment");
    protected CommonConfigReader commonConfig =
            new CommonConfigReader("config/Common.properties");
    protected EnvironmentConfigReader envConfig =
            new EnvironmentConfigReader(String.format("config/Env%s.properties", envName));

    public BaseTest() { };
}
