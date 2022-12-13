package com.tutorialninja.testsuite;


import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.page.Desktops;
import com.tutorialninja.page.HomePage;
import com.tutorialninja.page.LaptopsAndNotebooks;
import com.tutorialninja.testbase.BaseTest;;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopTest extends BaseTest {
    HomePage homePage;
    Desktops desktops;
    LaptopsAndNotebooks laptopsAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktops = new Desktops();
        laptopsAndNotebooks = new LaptopsAndNotebooks();
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.verifyZtoAforDropDroDown();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.SortByNameZtoAfromDropdown();
        desktops.clickOnHPlp3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktops.getVerifyTextHp(), expectedMessage, "Error Message not displayed");
        desktops.selectDeliveryDate();
        //desktops.changeQuantity("2");
        desktops.clickOnAdToCart();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(desktops.getVerifyShoppingCart(), expectedMessage, "Error Message not displayed");
        desktops.clickOnShppingCart();
        Thread.sleep(1000);
        //Assert.assertEquals(desktops.getVerifyShoppingCart(), "Shopping Cart", "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
        //  String expectedMessage4 = "2022-11-30";
        // Assert.assertEquals(desktops.getVerifyDeliveryDate(), expectedMessage, "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyModel(), "Product Code: Product 21", "Error Message not displayed");
        Thread.sleep(1000);
        //Assert.assertEquals(desktops.getVerifyTotal(), "£74.73", "Error Message not displayed");

    }
}
