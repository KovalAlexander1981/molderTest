package Pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static Helpers.Utils.*;


public class SettingsPage extends BasePage {

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnAddCategory;

    @AndroidFindBy(className = "android.widget.EditText")
    @FindBy(className = "android.widget.EditText")
    private WebElement textNameCategory;

    @AndroidFindBy(id = "android:id/button1")
    @FindBy(id = "android:id/button1")
    private WebElement btnOk;

    @AndroidFindBy(id = "com.slava.buylist:id/title")
    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listCategory;

    @AndroidFindBy(id = "android:id/title")
    @FindBys(@FindBy(id = "android:id/title"))
    private List<WebElement> listRemoveSettings;

    @AndroidFindBy(id = "android:id/text1")
    @FindBys(@FindBy(id = "android:id/text1"))
    private List<WebElement> choseOrientation;

    @AndroidFindBy(id = "android:id/title")
    @FindBys(@FindBy(id = "android:id/title"))
    private List<WebElement> categorySettings;

    @AndroidFindBy(id = "android:id/text1")
    @FindBys(@FindBy(id = "android:id/text1"))
    private List<WebElement> currencyList;


    public HomePage backButtonTwiceZ() {
        backButtonTwice();
        return new HomePage();
    }


    public SettingsPage clickListRemoveSettings() {
        for (int i = 0; i < listRemoveSettings.size(); i++) {
            String d = listRemoveSettings.get(i).getText();
            if ("Units".equals(d)) {
                listRemoveSettings.get(i).click();
                listRemoveSettings.get(i + 1).click();
                listRemoveSettings.get(i + 2).click();
            }
        }
        return this;
    }

    public HomePage ChangeOrientation(String name) {
        for (int i = 0; i < listRemoveSettings.size(); i++) {
            String d = listRemoveSettings.get(i).getText();
            if ("Orientation".equals(d)) {
                listRemoveSettings.get(i).click();
            }
        }
        if ("Horizontal".equals(name)) {
            choseOrientation.get(0).click();
        } else if ("Vertical".equals(name)) {
            choseOrientation.get(1).click();
        }
        return new HomePage();
    }

    public HomePage addNewCategoryGoods(String category, String option) {
        try {
            scroll();
            categorySettings.stream().filter(item -> item.getText().equals(category)).forEach(item -> item.click());
        } catch (WebDriverException e) {
            scroll();
            categorySettings.stream().filter(item -> item.getText().equals(category)).forEach(item -> item.click());
        }
        btnAddCategory.click();
        textNameCategory.sendKeys(option);
        btnOk.click();
        backButton();
        return backButtonTwice();
    }


    public SettingsPage setCategoryCurrency(String category, String option) {
        categorySettings.stream().filter(item -> item.getText().trim().equals(category)).findFirst().get().click();
        currencyList.stream().filter(items -> items.getText().trim().equals(option)).findFirst().get().click();
        return this;
    }


}














