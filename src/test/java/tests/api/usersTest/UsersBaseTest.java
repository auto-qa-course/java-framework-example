package tests.api.usersTest;

import customLibs.api.users.UsersAPI;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import tests.api.BaseTest;


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

