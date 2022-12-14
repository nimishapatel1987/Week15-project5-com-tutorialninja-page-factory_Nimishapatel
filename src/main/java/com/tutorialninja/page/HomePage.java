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

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement verifyText;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopNotebookLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement verifyText1;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement verifyText2;

    public void clickOnDesktopLink() {
        Reporter.log("clickOnDesktopLink" + desktopLink.toString());
        clickOnElement(desktopLink);
    }

    public String getVerifyText() {
        Reporter.log("verifyText" + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public void clickOnLaptopNotebooksLink() {
        Reporter.log("laptopNotebookLink" + laptopNotebookLink.toString());
        clickOnElement(laptopNotebookLink);
    }

    public String getVerifyText1() {
        Reporter.log("verifyText1" + verifyText1.toString());
        return getTextFromElement(verifyText1);
    }

    public void clickOnComponantsLink() {
        Reporter.log("componentsLink" + componentsLink.toString());
        clickOnElement(componentsLink);
    }

    public String getVerifyText2() {
        Reporter.log("verifyText2" + verifyText2.toString());
        return getTextFromElement(verifyText2);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }
}
