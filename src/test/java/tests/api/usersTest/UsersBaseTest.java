package tests.api.usersTest;

import customLibs.api.users.UsersAPI;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import tests.api.BaseTest;
import customLibs.utils.LogListener;


@Listeners(LogListener.class)
@Epic("Service Users")
public class UsersBaseTest extends BaseTest {

    UsersAPI usersAPI;

    @BeforeClass
    public void SetupBaseURL() {
        usersAPI = new UsersAPI(this.commonConfig, this.logger);
        RestAssured.baseURI = envConfig.getMainServiceURL();
    }

    UsersBaseTest() { super(); }
}

