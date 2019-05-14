package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestDate.Tare;

import static Helpers.Utils.backButtonTwice;


public class NewListWithProductsTest extends BaseTest {

    @Test(description = "Create new list with products")
    public void NewListWithProductsTest() {
        app.homePage.createNewList("Happy Friday", "");
        int f = app.createList.addNewProductToListGetPriceIt("Cat food", "22", "1", Tare.pack.name(), "For my kitty", "Pet products");
        int s = app.createList.addNewProductToListGetPriceIt("Milk", "18", "1", Tare.l.name(), "i like milk", "Dairy produce");
        int d = app.createList.addNewProductToListGetPriceIt("Soap", "12", "3", Tare.g.name(), "wash", "Cosmetics, hygiene");
        Assert.assertEquals(f + s + d, app.createList.getCheckPrice());
        backButtonTwice();


    }

}
