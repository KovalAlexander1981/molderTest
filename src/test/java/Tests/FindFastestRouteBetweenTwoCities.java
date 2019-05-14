package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;



public class FindFastestRouteBetweenTwoCities extends BaseTest {
    @Test(description = "FindFastestRouteBetweenTwoCities")
    public void FindFastestRouteBetweenTwoCities()  {
        Assert.assertTrue(app.homePage.searchCity("Kharkiv").isGetTipsListContains("Kharkiv"));
        Assert.assertTrue(app.homePage.createRoute("kiev"));
    }
}
