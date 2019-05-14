package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveListWithGoodsTest extends BaseTest {

    @Test(description = "Delete list with goods")
    public void RemoveListWithGoodsTest() {
        Assert.assertEquals((app.homePage.buylists() - 1), app.homePage.deleteList().buylists());
    }

}
