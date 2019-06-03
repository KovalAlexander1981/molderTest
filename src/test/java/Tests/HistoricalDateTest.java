package Tests;

import TestDate.Period;
import org.testng.annotations.Test;


public class HistoricalDateTest extends BaseTest {


    @Test(description = "Check that elements of Filters block")
    public void checkElementsFilterBlock() {
        app.financeStockPage
                .checkStockNames()
                .checkfiltersBlock();
    }

    @Test(description = "Check possibility to enter date manually")
    public void checkDateEntry() throws InterruptedException {
        app.financeStockPage
                .checkStockNames()
                .setDate("5/13/2019", "5/26/2019")
                .checkAmountOfDays(10, 3);
    }

    @Test(description = "Check time periods")
    public void checkPeriod() {
        app.financeStockPage
                .checkStockNames()
                .setPeriod(Period.fiveDay)
                .checkAmountOfDaysWithPeriod(Period.fiveDay);
    }

}