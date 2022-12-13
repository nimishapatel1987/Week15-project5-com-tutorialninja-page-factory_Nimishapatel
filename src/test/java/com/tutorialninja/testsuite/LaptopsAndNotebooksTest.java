package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.page.Desktops;
import com.tutorialninja.page.LaptopsAndNotebooks;
import com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    Desktops desktops;
    LaptopsAndNotebooks laptopsAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        desktops = new Desktops();
        laptopsAndNotebooks = new LaptopsAndNotebooks();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), " ");
        laptopsAndNotebooks.clickOnUpdateCart();

        //Assert.assertEquals(laptopsAndNotebooks.getVerifyCartText(), "Success: You have added MacBook to your shopping cart!\n" +

        Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        laptopsAndNotebooks.enterName("Pari");
        laptopsAndNotebooks.enterLastName("Patel");
        laptopsAndNotebooks.enterTelephone("123456");
        laptopsAndNotebooks.enterAddress("Hilton Road");
        laptopsAndNotebooks.enterCity("Cambridge");
        laptopsAndNotebooks.enterPostcode("Cb4 3NB");
        laptopsAndNotebooks.enterCountry("UK");
        laptopsAndNotebooks.enterState("Cambridge");

        laptopsAndNotebooks.clickOnCheckout();
       // laptopsAndNotebooks.enterText("Please Update Delivery date.");

        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }
}
