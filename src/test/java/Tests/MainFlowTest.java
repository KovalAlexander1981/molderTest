package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class MainFlowTest extends BaseTest {

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        app.homePage.restoreDataBase();
    }

    @Test(description = "Check user address")
    public void checkUserAddress()   {
        String address = ResourceBundle.getBundle("testData").getString("address.for.check");
        app.homePage
                .sendQuery("SELECT Address FROM Customers WHERE ContactName='Giovanni Rovelli'")
                .checkResultIsPresent()
                .checkResult("Address", address);
    }

    @Test(description = "Check check the number of records for column {0}")
    public void checkNumberOfRecords()   {
        String amount = ResourceBundle.getBundle("testData").getString("result.amount.for.check");
        app.homePage
                .sendQuery("SELECT count(City) FROM Customers WHERE City='London'")
                .checkResultIsPresent()
                .checkResultForAggregateFunc("count","City", amount);
    }

    @Test(description = "Insert new user")
    public void insertNewUser()   {
        List<String> newUser = Arrays.asList("'92', ", "'Fox Molder', ", "'John Do', ", "'Ocean Drive 21',", "'Bangkok', ", "'23455', ", "'Thailand'");
        app.homePage
                .insertNewUserQuery(newUser, "Customers")
                .sendQuery("SELECT * FROM Customers WHERE CustomerID="+newUser.get(0).replaceAll(",", "")+"")
                .checkAllUserInfo(newUser);
    }

    @Test(description = "Update user info")
    public void updateUserInfo()   {
        List<String> updateUser = Arrays.asList("'91', ", "'Rob N', ", "'Sam Do', ", "'Drive 21',", "'Tokyo', ", "'33333', ", "'USA'");
        app.homePage
                .updateUserInfo(updateUser, "Customers")
                .sendQuery("SELECT * FROM Customers WHERE CustomerID="+updateUser.get(0).replaceAll(",", "")+"")
                .checkAllUserInfo(updateUser);
    }
}
