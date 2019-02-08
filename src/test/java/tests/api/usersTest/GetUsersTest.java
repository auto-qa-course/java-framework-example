package tests.api.usersTest;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


@Story("Story 1 'As a system admin I want to be able get users list using REST API'" )
public class GetUsersTest extends UsersBaseTest {

    public GetUsersTest() { super(); }

    @Test(description = "Test root GET users endpoint.")
    public void TestUsersGet() {
        when().
                get(usersAPI.path).
        then().
                assertThat().statusCode(200);
    }

    @Test(description = "Test GET Users pagination - page number parameter.")
    public void TestUsersGetPaginationByPageNumber() {
        int pageNumber = 1;
        when().
                get(usersAPI.getUsersByPagePath(pageNumber)).
        then().
                assertThat().statusCode(200).
                assertThat().body("page", equalTo(pageNumber));
    }

    @Test(description = "Test GET Users pagination - page size parameter.")
    public void TestUsersGetPaginationPerPageSize() {
        int pageSize = 10;
        ArrayList<String> response =
                when().
                get(usersAPI.getUsersBySizePath(pageSize)).
        then().
                assertThat().statusCode(200).
        extract().
                  path("data");
        System.out.println(response);
    }

    @Test(description = "Test GET Users pagination - page number & size parameter.")
    public void TestUsersGetPaginationPerPageSizeAndPageNumber() {
        int pageNumber = 2;
        int pageSize = 10;
        ArrayList<String> response =
                when().
                        get(usersAPI.getUsersByPagePerPageSizePath(pageNumber, pageSize)).
                        then().
                        assertThat().statusCode(200).
                        extract().
                        path("data");
        System.out.println(response);
    }

    @Test(description = "Test GET Users pagination - empty page.")
    public void TestUsersGetPaginationPageEmpty() {
        int pageNumber = 1;
        int pagesNumber =
        when().
                get(usersAPI.getUsersByPagePath(pageNumber)).
                then().
                assertThat().statusCode(200).
                extract().
                path("total_pages");
        System.out.println(pagesNumber);

        pageNumber = pagesNumber + 1;
        ArrayList data_content = new ArrayList<>();
        when().
                get(usersAPI.getUsersByPagePath(pageNumber)).
                then().
                assertThat().statusCode(200).
                assertThat().body("total_pages", equalTo(pagesNumber)).
                assertThat().body("data", equalTo(data_content));
    }
}