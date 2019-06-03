package Helpers;

import Drivers.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Utils  extends DriverFactory {

    public static void stopApp() {
        driver.quit();
    }

    public static void checkListNotNullNorEmpty(List list) {
        if (list == null || list.isEmpty()) {
            throw new AssertionError("List is null or empty");
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        }

}

