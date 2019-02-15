package tests.api.usersTest;

import commonLibs.api.users.UsersAPI;
import commonLibs.api.users.UsersData;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import tests.api.BaseTest;

import java.util.HashMap;


@Epic("Service Users")
public class UsersBaseTest extends BaseTest {

    UsersAPI usersAPI;
    UsersData usersData;

    @BeforeClass
    public void SetupBaseURL() {
        usersAPI = new UsersAPI(this.commonConfig, this.logger);
        usersData = new UsersData(this.commonConfig);
        RestAssured.baseURI = envConfig.getMainServiceURL();
    }

    @DataProvider(name = "emptyUser")
    public static Object[][] generateEmptyUser() {
        return new Object[][] { { new HashMap<>() }};
    }

    UsersBaseTest() { super(); }
}

