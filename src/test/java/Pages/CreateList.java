package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Helpers.Utils.*;
import static java.lang.Integer.parseInt;

public class CreateList extends BasePage {

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    @FindBy(id = "com.slava.buylist:id/editText1")
    private WebElement textGoods;

    @AndroidFindBy(id = "com.slava.buylist:id/textView1")
    @FindBy(id = "com.slava.buylist:id/textView1")
    private WebElement listName;

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    @FindBy(id = "com.slava.buylist:id/editText1")
    private WebElement textFieldProductName;

    @AndroidFindBy(id = "com.slava.buylist:id/editText2")
    @FindBy(id = "com.slava.buylist:id/editText2")
    private WebElement numberFieldPrice;

    @AndroidFindBy(id = "com.slava.buylist:id/value")
    @FindBy(id = "com.slava.buylist:id/value")
    private WebElement currency;

    @AndroidFindBy(id = "com.slava.buylist:id/editText3")
    @FindBy(id = "com.slava.buylist:id/editText3")
    private WebElement numberFieldAmount;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner1")
    @FindBy(id = "com.slava.buylist:id/spinner1")
    private WebElement dporTare;

    @AndroidFindBy(id = "com.slava.buylist:id/editText4")
    @FindBy(id = "com.slava.buylist:id/editText4")
    private WebElement commentsField;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner2")
    @FindBy(id = "com.slava.buylist:id/spinner2")
    private WebElement dropCategory;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    @FindBy(id = "com.slava.buylist:id/button2")
    private WebElement addProduct;


    @AndroidFindBy(id = "com.slava.buylist:id/textView2")
    @FindBy(id = "com.slava.buylist:id/textView2")
    private WebElement listPrice;

    @AndroidFindBy(id = "com.slava.buylist:id/str1")
    @FindBy(id = "com.slava.buylist:id/str1")
    private WebElement textCommentary;

    @AndroidFindBy(id = "com.slava.buylist:id/TextView01")
    @FindBy(id = "com.slava.buylist:id/TextView01")
    private WebElement textAmount;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[4]")
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[4]")
    private WebElement textPrice;

    @AndroidFindBy(id = "com.slava.buylist:id/title")
    @FindBy(id = "com.slava.buylist:id/title")
    private WebElement getNameGood;


    public String getNameGood() {
        return getNameGood.getText();
    }

    public String getListName() {
        return listName.getText();
    }

    public CreateList addNewProductToList(String goods, String orientation) {
        textFieldProductName.sendKeys(goods);
        if ("Horizontal".equals(orientation)) {
            for (int i = 0; i < 3; i++) {
                tap(0.85, 0.19);
            }
            try{
            addProduct.click();}
            catch(WebDriverException e) {
                tap(0.85, 0.19);
                addProduct.click();
            }
        } else {
            addProduct.click();
        }
        return this;
    }

    public int getCheckPrice() {
        return parseInt(listPrice.getText().replaceAll("[^0-9]+", ""));
    }

    public String getCurrency() {
        return listPrice.getText();
    }

    public String getComents() {
        return textCommentary.getText();
    }

    public String getAmount() {
        return textAmount.getText();
    }

    public String getPrice() {
        return textPrice.getText();
    }


    public boolean isElementPresent(String element) {
        boolean b = false;
        try {
      findElementByXPath("//*[@text='" + element + "']");
        } catch (NoSuchElementException ex) {
            b = true;
        }
        return b;
    }

    public HomePage  backButtonTwiceZ(){
        backButtonTwice();
         return new HomePage();
    }


    public CreateList addNewProductToList(String goods, int priceGood) {
        textFieldProductName.sendKeys(goods);
        numberFieldPrice.sendKeys(priceGood + "");
        addProduct.click();
        return this;
    }

    public String checkCurrency(String goods) {
        textFieldProductName.sendKeys(goods);
        String curNow = currency.getText();
        addProduct.click();
        return curNow;
    }



    public int addNewProductToListGetPriceIt(String goods, String priceGood, String amountGood, String Tare, String comments, String category) {
        int price_good = parseInt(amountGood) * parseInt(priceGood);
        textFieldProductName.sendKeys(goods);
        numberFieldPrice.sendKeys(priceGood);
        numberFieldAmount.sendKeys(amountGood);
        dporTare.click();
        findElementByXPath(Tare);
        commentsField.sendKeys(comments);
        dropCategory.click();
        findElementByXPath(category);
        addProduct.click();
        return price_good;
    }


}




