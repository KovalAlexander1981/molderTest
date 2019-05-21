package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Helpers.Utils.*;


import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@class='w3-green w3-btn']")
    private WebElement runSQLButton;

    @FindBy(xpath = "//div[@style='margin-bottom:10px;']")
    private WebElement numberOfRecords;

    @FindBy(xpath = "//div[@id='divResultSQL']/div")
    private WebElement changeDataBaseLabel;

    @FindBy(xpath = "//div[@id='dbInfo']//button")
    private WebElement restoreDataBaseButton;

    @FindBy(xpath = "//table[@class='w3-table-all notranslate']//tr/th")
    private List<WebElement> columnName;

    @FindBy(xpath = "//table[@class='w3-table-all notranslate']//tr/td")
    private List<WebElement> userDataOrAggregateFunctionResult;

    public void restoreDataBase() throws InterruptedException {
        restoreDataBaseButton.click();
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {

        }
        Thread.sleep(2000);
        Assert.assertEquals(changeDataBaseLabel.getText(), "The database is fully restored.");
    }

    public HomePage sendQuery(String query) {
        String queryJS = "window.editor.setValue(\"" + query + ";\")";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(queryJS);
        runSQLButton.click();
        return this;
    }

    public HomePage insertNewUserQuery(List userData, String table) {
        String newUserQuery = "INSERT INTO "+table+" VALUES("+
                userData.get(0).toString()+" "+
                userData.get(1).toString()+" "+
                userData.get(2).toString()+" "+
                userData.get(3).toString()+" "+
                userData.get(4).toString()+" "+
                userData.get(5).toString()+" "+
                userData.get(6).toString()+")";
        sendQuery(newUserQuery);
        runSQLButton.click();
        Assert.assertEquals(changeDataBaseLabel.getText(), "You have made changes to the database. Rows affected: 1",
                "New user  was not added to the base");
        return this;
    }

    public HomePage updateUserInfo(List userData, String table) {
        List<String> columnName = Arrays.asList("CustomerID=", "CustomerName=", "ContactName=", "Address=", "City=", "PostalCode=", "Country=");
        String newUserQuery = "UPDATE "+table+" SET "+
                columnName.get(1).toString()+userData.get(1).toString()+" "+
                columnName.get(2).toString()+userData.get(2).toString()+" "+
                columnName.get(3).toString()+userData.get(3).toString()+" "+
                columnName.get(4).toString()+userData.get(4).toString()+" "+
                columnName.get(5).toString()+userData.get(5).toString()+" "+
                columnName.get(6).toString()+userData.get(6).toString()+"" +
                " Where "+columnName.get(0).toString()+userData.get(0).toString().replaceAll("[',]", "").trim()+"";
        sendQuery(newUserQuery);
        runSQLButton.click();
        Assert.assertEquals(changeDataBaseLabel.getText(), "You have made changes to the database. Rows affected: 1", "User data was not updated in the base");
        return this;
    }

    public HomePage checkResultIsPresent() {
        Assert.assertTrue(numberOfRecords.isDisplayed(), "Result is not showed");
        return this;
    }

    public void checkResult(String column, String checkData) {
        checkListNotNullNorEmpty(columnName);
        checkListNotNullNorEmpty(userDataOrAggregateFunctionResult);

        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).getText().equals(column))
                 Assert.assertEquals(userDataOrAggregateFunctionResult.get(i).getText(), checkData,
                         "Data is not the equal"+checkData);
        }
    }

    public void checkResultForAggregateFunc(String function, String column, String checkData) {
        checkListNotNullNorEmpty(columnName);
        checkListNotNullNorEmpty(userDataOrAggregateFunctionResult);
        String columnForCheck = function.concat("("+column+")");
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).getText().equals(columnForCheck))
                Assert.assertEquals(userDataOrAggregateFunctionResult.get(i).getText(), checkData,
                        "Data is not the equal"+checkData);
        }
    }

    public void checkAllUserInfo(List userInfo) {
        checkListNotNullNorEmpty(userDataOrAggregateFunctionResult);
        for (int i = 0; i < userInfo.size(); i++) {
            Assert.assertEquals(userDataOrAggregateFunctionResult.get(i).getText(),
                    userInfo.get(i).toString().replaceAll("[',]", "").trim());
        }
    }

}
