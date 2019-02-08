package tests.api.usersTest;

import tests.api.BaseTest;
import customLibs.api.users.UsersAPI;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.qameta.allure.Epic;


@Epic("Service Users")
public class UsersBaseTest extends BaseTest {

    UsersAPI usersAPI;

    @BeforeClass
    public void SetupBaseURL() {
        usersAPI = new UsersAPI(this.commonConfig);
        RestAssured.baseURI = envConfig.getMainServiceURL();
    }

    UsersBaseTest() { super(); }
}
