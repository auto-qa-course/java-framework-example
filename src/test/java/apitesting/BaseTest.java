package apitesting;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite()
    public void testSetup() {
        System.out.println("Setup test preconditions.");
    }

    public BaseTest() {
        System.out.println("Let's write some test cases!");
    }
}