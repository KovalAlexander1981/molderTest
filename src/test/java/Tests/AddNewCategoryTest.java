package Tests;


import TestDate.Tare;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helpers.Utils.backButtonTwice;


public class AddNewCategoryTest extends BaseTest {
    @Test(description = "Add new category in the products category list")
    public void AddNewCategoryTest() {
        Assert.assertEquals(app.homePage.clickButtonSet()
                .addNewCategoryGoods("Categories List", "Alfa")
                .createNewList("Victory", "")
                .addNewProductToListGetPriceIt("Cat food", "22", "1", Tare.bottles.name(), "For my kitty", "Alfa"), app.createList.getCheckPrice());
        backButtonTwice().deleteList();
    }
}
