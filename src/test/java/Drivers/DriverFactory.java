package Drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {
    public static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;


    public static WebDriver getDriver() {


        String property = System.getProperty("driver");

        if ("ios".equals(property)) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", "/Users/akoval/Downloads/JCPenney.app");
            caps.setCapability("platformVersion", "12.1");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 7 Plus");
            caps.setCapability("automationName", "XCUITest");
            try {
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Nexus 5");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "7.0");
            caps.setCapability("appPackage", "com.slava.buylist");
            caps.setCapability("appActivity", "com.slava.buylist.MainActivity");
            try {
                driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            wait = new WebDriverWait(driver, 10);
        }
        return driver;
    }

}










