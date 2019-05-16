package Drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static TestDate.Constant.BASE_URL;


public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "//Users/akoval/molder/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        return driver;
    }

}












