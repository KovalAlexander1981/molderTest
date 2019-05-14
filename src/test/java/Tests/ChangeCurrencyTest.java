package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends BaseTest {

    @Test(description = "Change currency in the APP")
    public void ChangeCurrencyTest() {
        String newCurrency = "$";
        app.homePage.createNewList("Asus", "").addNewProductToList("Oil", "");
        Assert.assertTrue(app.homePage.clickButtonSet().setCategoryCurrency("Currency", newCurrency).backButtonTwiceZ().infoList().contains(newCurrency));
        Assert.assertTrue(app.homePage.openList("Asus").checkCurrency("Car").contains(newCurrency));
        app.createList.backButtonTwiceZ().deleteList().deleteList();
    }
}
