package api.usersServiceTest;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


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
        int page_number = 1;
        when().
                get(String.format("/users?page=%s", page_number)).
        then().
                assertThat().statusCode(200).
                assertThat().body("page", equalTo(page_number));
    }

    @Test(description = "Test GET Users pagination - page size parameter.")
    public void TestUsersGetPaginationPerPageSize() {
        int page_size = 10;
        ArrayList<String> response =
                when().
                get(String.format("/users?per_page=%s", page_size)).
        then().
                assertThat().statusCode(200).
        extract().
                  path("data");
        System.out.println(response);
    }

    @Test(description = "Test GET Users pagination - page number & size parameter.")
    public void TestUsersGetPaginationPerPageSizeAndPageNumber() {
        int page_number = 2;
        int page_size = 10;
        ArrayList<String> response =
                when().
                        get(String.format("/users?page=%s&per_page=%s", page_number, page_size)).
                        then().
                        assertThat().statusCode(200).
                        extract().
                        path("data");
        System.out.println(response);
    }

    @Test(description = "Test GET Users pagination - empty page.")
    public void TestUsersGetPaginationPageEmpty() {
        int page_number = 1;
        int pages_number =
        when().
                get(String.format("/users?page=%s", page_number)).
                then().
                assertThat().statusCode(200).
                extract().
                path("total_pages");
        System.out.println(pages_number);

        page_number = pages_number + 1;
        ArrayList data_content = new ArrayList<>();
        when().
                get(String.format("/users?page=%s", page_number)).
                then().
                assertThat().statusCode(200).
                assertThat().body("total_pages", equalTo(pages_number)).
                assertThat().body("data", equalTo(data_content));
    }
}