package Tests;

import Pages.AllPages;
import org.testng.annotations.AfterSuite;

import static Drivers.DriverFactory.driver;

public class BaseTest {

    protected static AllPages app = new AllPages();

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }
}
