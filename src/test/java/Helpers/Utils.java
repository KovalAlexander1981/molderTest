package Helpers;

import Drivers.DriverFactory;

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

}

