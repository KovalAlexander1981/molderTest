package Tests;

import Pages.AllPages;
import org.testng.annotations.AfterSuite;

import static Helpers.Utils.stopApp;

public class BaseTest {

    protected static AllPages app = new AllPages();


    @AfterSuite
    public void tearDownSuite() {
        stopApp();
    }
}
