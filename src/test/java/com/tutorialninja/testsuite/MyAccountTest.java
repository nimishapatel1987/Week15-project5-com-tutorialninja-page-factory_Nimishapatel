package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.page.MyAccount;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    MyAccount myAccount;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccount = new MyAccount();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
       // myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
      //  MyAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
   //     myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterPassword("123456");
        myAccount.enterFirstName("Pari");
        myAccount.enterLastName("Patel");
   //   myAccount.enterEmailAdd("test12"+getAlphaNumericString(2)+"@gmail.com");
        myAccount.enterPhone("123456");
        myAccount.enterPassword("020123456");
        myAccount.enterConfirmPass("020123456");
     //   myAccount.clickYesOnNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();
        Assert.assertEquals(myAccount.getVerifyMessage(), "Register Account", "Error Message not displayed");
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");

    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");
        myAccount.enterEmailAdd("paripatel123@gmail.com");
        myAccount.enterPassword("123456");
        myAccount.selectMyAccountOptions("Logout");
    }
}
