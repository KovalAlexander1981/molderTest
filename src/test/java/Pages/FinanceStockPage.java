package Pages;

import TestDate.Period;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Helpers.Utils.*;
import static java.lang.Thread.*;

import java.util.List;

public class FinanceStockPage extends BasePage {

    @FindBy(xpath = "//div[@id='Col1-1-HistoricalDataTable-Proxy']//button")
    private WebElement applyButton;

    @FindBy(xpath = "//div[@class='Bgc($extraLightGray) Bdrs(3px) P(10px)']//span[@class='Mend(8px)']")
    private List<WebElement> showAndFrequencyLabel;

    @FindBy(xpath = "//div[@class='Bgc($extraLightGray) Bdrs(3px) P(10px)']//span[starts-with(text(), 'Time')]")
    private WebElement timePeriodLabel;

    @FindBy(xpath = "//div[@class='Bgc($extraLightGray) Bdrs(3px) P(10px)']//input")
    private WebElement timeField;

    @FindBy(xpath = "//div[@class='Bgc($extraLightGray) Bdrs(3px) P(10px)']/div/span[1]/span")
    private List<WebElement> filtersLabels;

    @FindBy(xpath = "//div[@class='Bgc($extraLightGray) Bdrs(3px) P(10px)']//span[@data-test='historicalFrequency-selected']")
    private WebElement frequencyField;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//tbody/tr/td[1]/span")
    private List<WebElement> dateColumn;

    @FindBy(xpath = "//div[@class='Ta(c) C($gray)']//span/span")
    private List<WebElement> periodButtons;

    @FindBy(xpath = "//div[@class='Mt(20px)']/button/span[text()='Done']")
    private WebElement doneButton;

    @FindBy(xpath = "//div[@class='Mt(20px)']/button/span[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='D(ib) ']/h1")
    private WebElement stockName;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//tbody/tr[last()]/td[1]/span")
    private WebElement firstDayPeriod;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//tbody/tr[1]/td[1]/span")
    private WebElement lastDayPeriod;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//tbody/tr/td[1]/span")
    private List<WebElement> dateList;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//div/input[1]")
    private WebElement setStartDate;

    @FindBy(xpath = "//*[@id='Col1-1-HistoricalDataTable-Proxy']//div/input[2]")
    private WebElement setEndDate;

    @FindBy(xpath = "//*[text()='Weekly']")
    private WebElement frequencyWeeklyLabel;



    public FinanceStockPage checkfiltersBlock() {
        checkListNotNullNorEmpty(filtersLabels);

        Assert.assertEquals(filtersLabels.get(0).getText(), "Time Period", "Time Period label is not the same or not displayed");
        Assert.assertEquals(filtersLabels.get(1).getText(), "Show:", "Show label is not the same or not displayed");
        Assert.assertEquals(filtersLabels.get(2).getText(), "Frequency:", "Frequency label is not the same or not displayed");
        Assert.assertTrue(applyButton.isDisplayed(), "Apply button is not displayed");

        return this;
    }

    public FinanceStockPage checkStockNames() {
        Assert.assertTrue(stockName.getText().contains("Amazon.com, Inc."), "Full company name is not displayed or wrong");
        Assert.assertTrue(stockName.getText().contains("AMZN"), "Short stock name is not displayed or wrong");

        return this;
    }

    public FinanceStockPage setPeriod(Period period) {
        timeField.click();
        for (WebElement element : periodButtons){
           if(element.getText().equals(period.toString())){
        element.click();
           break;}
        }
        doneButton.click();
        applyButton.click();

        return this;
    }

    public FinanceStockPage checkAmountOfDaysWithPeriod(Period period) {
        switch (period.toString()) {
            case ("1D"):
                Assert.assertTrue(dateList.size()<= 1,"Date list bigger than period");
                break;
            case ("5D"):
                Assert.assertTrue(dateList.size()<= 5,"Date list bigger than period");
                break;
            case ("3M"):
                Assert.assertTrue(dateList.size()<= 90,"Date list bigger than period");
                break;
        }

        return this;
    }

    public FinanceStockPage setDate(String startDate, String endDate) throws InterruptedException {
        timeField.click();
        setStartDate.clear();
        setStartDate.sendKeys(startDate);
        setEndDate.clear();
        setEndDate.sendKeys(endDate);
        doneButton.click();
        applyButton.click();
        sleep(1000);


        return this;
    }

    public FinanceStockPage checkAmountOfDays(int daily, int weekly) throws InterruptedException {

        Assert.assertEquals(dateList.size(), daily, "Date list not equal amount of notes");

        frequencyField.click();
        frequencyWeeklyLabel.click();
        applyButton.click();
        sleep(2000);

        Assert.assertEquals(dateList.size(), weekly, "Date list not equal amount of notes");

        return this;
    }
}
