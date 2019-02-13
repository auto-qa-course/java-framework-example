package tests.api;

import commonLibs.configurationReaders.EnvironmentConfigReader;
import commonLibs.configurationReaders.CommonConfigReader;
import commonLibs.utils.RestAssuredLogListener;
import commonLibs.utils.SimpleLogger;
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
