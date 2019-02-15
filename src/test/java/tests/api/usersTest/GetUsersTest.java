package tests.api.usersTest;

import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.empty;


@Story("Story 1 'As a system admin I want to be able get users list using REST API'" )
public class GetUsersTest extends UsersBaseTest {

    public GetUsersTest() { super(); }

    @Test(description = "Test root GET users endpoint.")
    public void TestUsersGet() {
        ValidatableResponse response = usersAPI.getUsers();

        response.assertThat().statusCode(usersAPI.SUCCESS_CODE);
    }

    @Test(description = "Test GET Users pagination - page number parameter.")
    public void TestUsersGetPaginationByPageNumber() {
        int pageNumber = 1;

        ValidatableResponse response = usersAPI.getUsersByPage(pageNumber);

        response.
                assertThat().statusCode(usersAPI.SUCCESS_CODE).
                assertThat().body("page", equalTo(pageNumber));
    }

    @Test(description = "Test GET Users pagination - page size parameter.")
    public void TestUsersGetPaginationPerPageSize() {
        int pageSize = 10;

        ValidatableResponse response = usersAPI.getUsersBySize(pageSize);

        response.assertThat().statusCode(usersAPI.SUCCESS_CODE);
    }

    @Test(description = "Test GET Users pagination - page number & size parameter.")
    public void TestUsersGetPaginationPerPageSizeAndPageNumber() {
        int pageNumber = 2;
        int pageSize = 10;

        ValidatableResponse response = usersAPI.getUsersByPagePerPageSize(pageNumber, pageSize);

        response.assertThat().statusCode(usersAPI.SUCCESS_CODE);
    }

    @Test(description = "Test Users pagination - GET not existing page.")
    public void TestUsersGetPaginationPageEmpty() {
        int pageNumber = 1;

        ValidatableResponse response = usersAPI.getUsersByPage(pageNumber);

        int totalPagesNumber = usersAPI.parseTotalPagesFromResponse(response);

        pageNumber = totalPagesNumber + 1;

        ValidatableResponse responseForEmptyPage = usersAPI.getUsersByPage(pageNumber);

        responseForEmptyPage.
                assertThat().statusCode(usersAPI.SUCCESS_CODE).
                assertThat().body("data", empty());
    }
}

