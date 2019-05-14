package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestDate.Tare;

import static Helpers.Utils.backButtonTwice;


public class InEixstListAddGoodsTest extends BaseTest {

    @Test(description = "In list that exist add new good")
    public void InEixstListAddGoodsTest() {
        int f = app.homePage.createNewList("January", "").addNewProductToListGetPriceIt("Cat food", "22", "1", Tare.pack.name(), "For my kitty", "Pet products");
        backButtonTwice();
        int g = app.homePage.openList("January").addNewProductToListGetPriceIt("Toys", "44", "5", Tare.bottles.name(), "Good", "Child products");
        Assert.assertEquals(f + g, app.createList.getCheckPrice());
        backButtonTwice();
        Assert.assertTrue(app.homePage.infoList().contains(f + g + ""));
        app.homePage.deleteList();
    }
}
