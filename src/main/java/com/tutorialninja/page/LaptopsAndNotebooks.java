package com.tutorialninja.page;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopLink;

    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement allLaptopAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbookLink;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement verifyMacbook;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement verifySuccess;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement verifyCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyProductMacbook;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement updateCart;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='product-product']/div[1]")
    WebElement verifyCartText;

    @CacheLookup
    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/button[1]")
    WebElement verifyTotal;

    @CacheLookup
    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/button[1]")
    WebElement clickOnCart;

    @CacheLookup
    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]")
    WebElement clickOnCheckout;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement verifyCheckout;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement verifyNewCustomer;

    @CacheLookup
    @FindBy(xpath = "//label[text()[normalize-space()='Guest Checkout']]")
    WebElement guestCheckout;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement nameField;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastnameField;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telePhone;

    @CacheLookup
    @FindBy(name = "address_1")
    WebElement addressLine;

    @CacheLookup
    @FindBy(name = "city")
    WebElement cityName;

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement zoneName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueCheckout;

    @CacheLookup
    @FindBy(tagName = "textarea")
    WebElement passText;

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsCondition;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement lastContinue;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    WebElement warningMsg;

    public void clickOnLaptopsLink() {
        Reporter.log("clickOnLaptopsLink" + laptopLink.toString());
        clickOnElement(laptopLink);
        CustomListeners.test.log(Status.PASS,"clickOnLaptopsLink");
    }
    public String shortPriceLowToHigh() {

        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return null;
    }

    public void changeCurrency() {

        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAllLaptopAndNotebooksLink() {
        Reporter.log("clickOnAllLaptopAndNotebooksLink" + allLaptopAndNotebooksLink.toString());
        clickOnElement(allLaptopAndNotebooksLink);
    }
    public void clickOnMacbookLink() {
        Reporter.log("clickOnMacbookLink" + macbookLink.toString());
        clickOnElement(macbookLink);
    }
    public String getVerifyMacbook() {
        Reporter.log("getVerifyMacbook" + verifyMacbook.toString());
        return getTextFromElement(verifyMacbook);
    }
    public void clickOnAddToCart() {
        Reporter.log("clickOnAddToCart" + addToCart.toString());
        clickOnElement(addToCart);
    }
    public String getVerifySuccess() {
        Reporter.log("getVerifySuccess" + verifySuccess.toString());
        return getTextFromElement(verifySuccess);
    }
    public void clickOnShoppingCart() {
        Reporter.log("clickOnShoppingCart" + addToCart.toString());
        clickOnElement(addToCart);
    }
    public String getVerifyCart() {
        Reporter.log("getVerifyCart" + verifyCart.toString());
        return getTextFromElement(verifyCart);
    }
    public String getVerifyProductMacbook() {
        Reporter.log("getVerifyProductMacbook" + verifyProductMacbook.toString());
        return getTextFromElement(verifyProductMacbook);
    }
    public void clickOnUpdateCart() {
        Reporter.log("clickOnUpdateCart" + updateCart.toString());
        clickOnElement(updateCart);
    }

    public String getVerifyCartText() {
        Reporter.log("getVerifyCartText" + verifyCartText.toString());
        return getTextFromElement(verifyCartText);
    }
    public String getVerifyTotal() {
        Reporter.log("getVerifyTotal" + verifyTotal.toString());
        return getTextFromElement(verifyTotal);
    }
    public void clickOnCheckoutCart() {
        Reporter.log("clickOnCheckoutCart" + clickOnCart.toString());
        clickOnElement(clickOnCart);
    }
    public void clickOnFinalCheckout() {
        Reporter.log("clickOnFinalCheckout" + clickOnCheckout.toString());
        clickOnElement(clickOnCheckout);
    }
    public String getVerifyCheckout() {
        Reporter.log("getVerifyCheckout" + verifyCheckout.toString());
        return getTextFromElement(verifyCheckout);
    }
    public String getVerifyNewCustomer() {
        Reporter.log("getVerifyNewCustomer" + verifyNewCustomer.toString());
        return getTextFromElement(verifyNewCustomer);
    }
    public void clickOnGuestCheckout() {
        Reporter.log("clickOnGuestCheckout" + guestCheckout.toString());
        clickOnElement(guestCheckout);
    }
    public void clickOnContinueTab() {
        Reporter.log("clickOnContinueTab" + continueTab.toString());
        clickOnElement(continueTab);
    }
    public void enterName(String name) {
        Reporter.log("enterName" + name +nameField.toString());
        sendTextToElement(nameField, name);
    }
    public void enterLastName(String lastname) {
        Reporter.log("enterLastName" +lastname+ lastnameField.toString());
        sendTextToElement(lastnameField, lastname);
    }
    public void enterTelephone(String phone) {
        Reporter.log("enterTelephone" +phone +telePhone.toString());
        sendTextToElement(telePhone, phone);
    }
    public void enterAddress(String street) {
        Reporter.log("enterAddress" + street +addressLine.toString());
        sendTextToElement(addressLine, street);
    }
    public void enterCity(String city) {
        Reporter.log("enterCity" + city +cityName.toString());
        sendTextToElement(cityName, city);
    }
    public void enterPostcode(String code) {
        Reporter.log("enterPostcode" + code + postCode.toString());
        sendTextToElement(postCode, code);
    }
    public void enterCountry(String country) {
        Reporter.log("enterCountry" + country + countryName.toString());
        sendTextToElement(countryName, country);
    }
    public void enterState(String state) {
        Reporter.log("enterState" + state + zoneName.toString());
        sendTextToElement(zoneName, state);
    }
    public void clickOnCheckout() {
        Reporter.log("clickOnCheckout" + continueCheckout.toString());
        clickOnElement(continueCheckout);
    }
    public void enterText(String msg) {
        Reporter.log("enterText" + msg + passText.toString());
        sendTextToElement(passText, msg);
    }
    public void clickOnTerms() {
        Reporter.log("clickOnTerms" + termsCondition.toString());
        clickOnElement(termsCondition);
    }
    public void clickContinue() {
        Reporter.log("clickContinue" + lastContinue.toString());
        clickOnElement(lastContinue);
    }
    public String getVerifyWarningMsg() {
        Reporter.log("getVerifyWarningMsg" + warningMsg.toString());
        return getTextFromElement(warningMsg);
    }
}
