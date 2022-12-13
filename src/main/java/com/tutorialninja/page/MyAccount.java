package com.tutorialninja.page;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccount extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement varifyRegister;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement varifyReturning;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmail;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement enterPhone;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement enterPass;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPass;
    @CacheLookup
    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement newsLetter;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickOnContinue;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement varifymessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    //Call the method “selectMyAccountOptions” method and pass the parameter
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement varifyLogout;

    //Call the method “selectMyAccountOptions” method and pass the parameter
    //“Login”
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public void clickOnLogin() {
        clickOnElement(loginButton);
    }
    //______________________________________________________________//

    public void clickonMyAccount() {
        Reporter.log("myAccount" + myAccount.toString());
        clickOnElement(myAccount);
    }

    public String getVerifyRegister() {
        Reporter.log("varifyRegister" + varifyRegister.toString());
        return getTextFromElement(varifyRegister);
    }

    public String getVerifyReturning() {
        Reporter.log("varifyReturning" + varifyReturning.toString());
        return getTextFromElement(varifyReturning);
    }

    public void enterFirstName(String name) {
        Reporter.log("firstName" + firstName.toString());
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String lastname) {
        Reporter.log("lastName" + lastName.toString());
        sendTextToElement(lastName, lastname);
    }

    public void enterEmailAdd(String email) {
        Reporter.log("enterEmail" + enterEmail.toString());
        sendTextToElement(enterEmail, email);
    }

    public void enterPhone(String phone) {
        Reporter.log("enterPhone" + enterPhone.toString());
        sendTextToElement(enterPhone, phone);
    }

    public void enterPassword(String phone) {
        Reporter.log("enterPass" + enterPass.toString());
        sendTextToElement(enterPass, phone);
    }

    public void enterConfirmPass(String phone) {
        Reporter.log("confirmPass" + confirmPass.toString());
        sendTextToElement(confirmPass, phone);
    }

    public void clickYesonNewsLetter() {
        Reporter.log("newsLetter" + newsLetter.toString());
        clickOnElement(newsLetter);
    }

    public void clickOnPrivacy() {
        Reporter.log("clickOnPrivacy" + privacyPolicy.toString());
        clickOnElement(privacyPolicy);
    }

    public void clickFinalContinue() {
        Reporter.log("clickOnContinue" + clickOnContinue.toString());
        clickOnElement(clickOnContinue);
    }

    public String getVerifyMessage() {
        Reporter.log("varifymessage" + varifymessage.toString());
        return getTextFromElement(varifymessage);
    }

    public void clickOnContinueButton() {
        Reporter.log("continueButton" + continueButton.toString());
        clickOnElement(continueButton);
    }

    public void clickOnMyAccountTab() {
        Reporter.log("myAccountTab" + myAccountTab.toString());
        clickOnElement(myAccountTab);
    }

    public String getVerifyLogout() {
        Reporter.log("varifyLogout" + varifyLogout.toString());
        return getTextFromElement(varifyLogout);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

}
