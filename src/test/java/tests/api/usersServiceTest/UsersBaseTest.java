package tests.api.usersServiceTest;

import tests.api.BaseTest;
import customLibs.api.UsersAPI;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;


public class UsersBaseTest extends BaseTest {

    UsersAPI usersAPI;

    @BeforeClass
    public void SetupBaseURL() {
        usersAPI = new UsersAPI(this.commonConfig);
        RestAssured.baseURI = envConfig.getMainServiceURL();
    }

    UsersBaseTest() { super(); }
}

