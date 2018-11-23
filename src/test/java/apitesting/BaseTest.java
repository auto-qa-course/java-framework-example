package apitesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite()
    public void deleteAllureOutputsFolder() {
        System.out.println("Setup test preconditions.");
    }

    public BaseTest() {
        System.out.println("Let's write some test cases!");
    }

}