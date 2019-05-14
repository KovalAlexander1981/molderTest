package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.allure.annotations.Description;

import static Helpers.Utils.*;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(name = "Search for a place or address")
    private WebElement searchField;

    @FindBy(xpath = "//XCUIElementTypeCell")
    private List<WebElement> tipsPlacesList;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Directions']")
    private WebElement btnDirections;

    @FindBy(xpath = "//XCUIElementTypeImage")
    private WebElement cityTextField;

    @FindBy(name = "Route")
    private WebElement bntRoute;

    @FindBys(@FindBy(xpath = "//XCUIElementTypeStaticText"))
    private List<WebElement> getInfoAboutRoute;

    @AndroidFindBy(id = "com.slava.buylist:id/button1; desc: 'btnPreferences' ")
    @FindBy(id = "com.slava.buylist:id/button1")
    private WebElement btnPreferences;

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    @FindBy(id = "com.slava.buylist:id/editText1")
    private WebElement textField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnAdd;

    @AndroidFindBy(id = "com.slava.buylist:id/imageView2")
    @FindBy(id = "com.slava.buylist:id/imageView2")
    private WebElement btnEdit;

    @AndroidFindBy(id = "com.slava.buylist:id/title")
    @FindBy(id = "com.slava.buylist:id/title")
    private WebElement listName;

    @AndroidFindBy(id = "com.slava.buylist:id/str1")
    @FindBy(id = "com.slava.buylist:id/str1")
    private WebElement listInfo;

    @AndroidFindBy(id = "com.slava.buylist:id/imageView1")
    @FindBys(@FindBy(id = "com.slava.buylist:id/imageView1"))
    private List<WebElement> listDelete;

    @AndroidFindBy(id = "android:id/button1")
    @FindBy(id = "android:id/button1")
    private WebElement Yes;

    @AndroidFindBy(id = "android:id/button2")
    @FindBy(id = "android:id/button2")
    private WebElement No;

    @AndroidFindBy(id = "com.slava.buylist:id/title")
    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listLists;

    @AndroidFindBy(className = "android.widget.EditText")
    @FindBy(className = "android.widget.EditText")
    private WebElement listChangeNameField;

    @AndroidFindBy(id = "com.slava.buylist:id/str1")
    @FindBy(id = "com.slava.buylist:id/str1")
    private WebElement stringInfoList;

    @AndroidFindBy(id = "com.slava.buylist:id/title")
    @FindBys(@FindBy(id = "com.slava.buylist:id/title"))
    private List<WebElement> listOfList;

    @AndroidFindBy(className = "android.widget.LinearLayout")
    @FindBy(className = "android.widget.LinearLayout")
    private WebElement settings;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement exitFromApp;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement btnDone;


    @Description("Search city in the list")
    public HomePage searchCity(String cityName) {
        searchField.sendKeys(cityName);
        return this;
    }

    public boolean isGetTipsListContains(String city) {
        return tipsPlacesList.stream().allMatch(s -> s.getText().contains(city));
    }

    public boolean createRoute(String city) {
        tipsPlacesList.get(0).click();
        btnDirections.click();
        cityTextField.sendKeys(city);
        bntRoute.click();
        return getInfoAboutRoute.stream().anyMatch(name -> name.getText().contains("Fastest"));
    }


    public int buylists() {
        return listLists.size();
    }

    public boolean isContainList(String name) {
        return listLists.stream().anyMatch(element -> element.getAttribute("text").matches(name));
    }


    public CreateList createNewList(String listName, String orientation) {
        textField.sendKeys(listName);
        if ("Horizontal".equals(orientation)) {
            tap(0.901, 0.266);
            tap(0.9, 0.3);
        } else {
            btnAdd.click();
        }
        return new CreateList();
    }

    public HomePage deleteList() {
        listDelete.get(1).click();
        Yes.click();
        return this;
    }

    public HomePage renameList(String newNameList) {
        btnEdit.click();
        listChangeNameField.clear();
        listChangeNameField.sendKeys(newNameList);
        Yes.click();
        return this;
    }

    public String infoList() {
        return stringInfoList.getText();
    }

    public CreateList openList(String name) {
        listOfList.stream().filter(item -> item.getText().equals(name)).forEach(item -> item.click());
        return new CreateList();
    }


    public SettingsPage clickButtonSet() {
        btnPreferences.click();
        settings.click();
        return new SettingsPage();
    }


    public HomePage backButtonZ() {
        backButton();
        return this;
    }


    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Shop\"]")
    private WebElement ss1;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"departmentCategories.cell.at.index.0.0.title\"]")
    private WebElement ss2;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"departmentCategories.cell.at.index.0.0.title\"]")
    private WebElement ss3;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"departmentCategories.cell.at.index.0.0.title\"]")
    private WebElement ss4;



    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='productListCell.cellItem.priceView']")
    private List<WebElement> tips;


    public void ddd() throws InterruptedException {
        Thread.sleep(2000);
        ss1.click();
        ss2.click();
        ss3.click();
        System.out.println(tips.size());
    }

}



