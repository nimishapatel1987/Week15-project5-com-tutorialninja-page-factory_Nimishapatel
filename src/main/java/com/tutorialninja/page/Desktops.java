package com.tutorialninja.page;

import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement clickOnShowAllDeskTop;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByNameZtoA;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement clickOnHpLp3065;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyText;

    //Select Delivery Date "2022-11-30"
    // By deliveryDate = By.xpath("//div[@class = 'input-group date']//button");
    //public void selectDeliveryDate() {
    //clickOnElement(deliveryDate);
    @CacheLookup
    @FindBy(name = "quantity")
    WebElement selectQuantity;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyTextHplp3065;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement clickShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyHPlp3065;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement verifyDate;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Product Code: Product 21')]")
    WebElement verifyModel;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotal;


    //-------------------------------------------------------------------------//
    public void clickOnCurrencyLink() {
        Reporter.log("currencyLink" + currencyLink.toString());
        clickOnElement(currencyLink);
    }

    public void clickOnAllDesktop() {
        Reporter.log("clickOnShowAllDeskTop" + clickOnShowAllDeskTop.toString());
        clickOnElement(clickOnShowAllDeskTop);
    }

    public void SortByNameZtoAfromDropdown() {
        Reporter.log("sortByNameZtoA" + sortByNameZtoA.toString());
        sendTextToElement(sortByNameZtoA, "Name (Z - A)");
    }

    public void clickOnHPlp3065() {
        Reporter.log("clickOnHpLp3065" + clickOnHpLp3065.toString());
        clickOnElement(clickOnHpLp3065);
    }

    public String getVerifyText() {
        Reporter.log("verifyText" + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public void changeQuantity(String quantity) {
        Reporter.log("selectQuantity" + selectQuantity.toString());
        sendTextToElement(selectQuantity, quantity);
    }

    public void clickOnAdToCart() {
        Reporter.log("addToCart" + addToCart.toString());
        clickOnElement(addToCart);
    }

    public String getVerifyTextHp() {
        Reporter.log("verifyTextHplp3065" + verifyTextHplp3065.toString());
        return getTextFromElement(verifyTextHplp3065);
    }

    //SelectDate
    public void selectDeliveryDate() {
        //select delivery date
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnShppingCart() {
        Reporter.log("clickShoppingCart" + clickShoppingCart.toString());
        clickOnElement(clickShoppingCart);
    }

    public String getVerifyShoppingCart() {
        Reporter.log("verifyShoppingCart" + verifyShoppingCart.toString());
        return getTextFromElement(verifyShoppingCart);
    }

    public String getVerifyProductName() {
        Reporter.log("verifyHPlp3065" + verifyHPlp3065.toString());
        return getTextFromElement(verifyHPlp3065);
    }

    public String getVerifyDeliveryDate() {
        Reporter.log("verifyDate" + verifyDate.toString());
        return getTextFromElement(verifyDate);
    }

    public String getVerifyModel() {
        Reporter.log("verifyModel" + verifyModel.toString());
        return getTextFromElement(verifyModel);
    }

    public String getVerifyTotal() {
        Reporter.log("verifyTotal" + verifyTotal.toString());
        return getTextFromElement(verifyTotal);
    }
    public void verifyZtoAforDropDroDown() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);

    }



}
