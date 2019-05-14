package Helpers;

import Drivers.DriverFactory;
import Pages.HomePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;


public class Utils  extends DriverFactory {

    public static void stopApp() {
        driver.closeApp();
    }

    public static   HomePage backButtonTwice() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        return new HomePage();
    }

    public static void backButton() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    public static void scroll() {

        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int y = (int) (size.height * 0.6);
        int endY = (int) (size.height * 0.1);

        new TouchAction(driver)
                .press(new PointOption().withCoordinates(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(2500)))
                .moveTo(new PointOption().withCoordinates(x, endY))
                .release()
                .perform();

    }

    public static void tap(double a, double b) {

        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * a);
        int y = (int) (size.height * b);
        new TouchAction(driver)
                .press(new PointOption().withCoordinates(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .release()
                .perform();
    }
    public  static void findElementByXPath(String name){
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='" + name + "']").click();
    }


}

