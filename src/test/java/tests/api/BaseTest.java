package tests.api;

import customLibs.configurationReaders.EnvironmentConfigReader;
import customLibs.configurationReaders.CommonConfigReader;
import customLibs.utils.RestAssuredLogListener;
import customLibs.utils.SimpleLogger;
import org.testng.annotations.Listeners;


@Listeners(RestAssuredLogListener.class)
public class BaseTest {

    private String envName = System.getProperty("environment");
    protected CommonConfigReader commonConfig =
            new CommonConfigReader("config/Common.properties");
    protected EnvironmentConfigReader envConfig =
            new EnvironmentConfigReader(String.format("config/Env%s.properties", envName));

    public SimpleLogger logger = new SimpleLogger();

    public BaseTest() { };
}
