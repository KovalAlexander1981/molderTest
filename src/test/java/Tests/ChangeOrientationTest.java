package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ChangeOrientationTest extends BaseTest {
    @Test(description = "Change the App orientation")

    public void ChangeOrientationTest() {
        app.homePage.clickButtonSet().ChangeOrientation("Horizontal").backButtonZ();
        app.homePage.createNewList("Wow", "Horizontal")
        .addNewProductToList("Cat food", "Horizontal");
        Assert.assertEquals("Wow", app.createList.getListName());
        Assert.assertEquals("Cat food", app.createList.getNameGood());
    }
}