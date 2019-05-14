package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateNewListTest extends BaseTest {


    @Test(description = "Create new empty list")
    public void CreateNewListTest() {
        int amountBefore = app.homePage.buylists();
        Assert.assertTrue(app.homePage.createNewList("Rambo", "").backButtonTwiceZ().isContainList("Rambo"));
        Assert.assertEquals((amountBefore + 1), app.homePage.buylists());
    }
}


