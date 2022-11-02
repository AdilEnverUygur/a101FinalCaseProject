package com.a101.pages;

import com.a101.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    WebDriver driver;
    Utility utility;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new Utility(driver);
    }

    @FindBy(xpath = "//button[.='Kabul Et']")
    WebElement acceptHandler;

    @FindBy(id = "myAccount")
    WebElement loginDropDownList;

    @FindBy(id = "login")
    WebElement loginLink;

    @FindBy(xpath = "//div[.='Yeni giriş yöntemi!']")
    WebElement verify;

    public void clickAcceptHandler(){
        utility.waitForElementPresent(acceptHandler);
        acceptHandler.click();
    }

    public void moveToDropDownList(){
        utility.waitForElementPresent(loginDropDownList);
        Actions actions = new Actions(driver);
        actions.moveToElement(loginDropDownList).build().perform();
    }

    public void clickLoginLink(){
        utility.waitForElementPresent(loginLink);
        loginLink.click();
    }

    public boolean isInLoginPage(){
        utility.waitForElementPresent(verify);
        if (verify.getText().equals("Yeni giriş yöntemi!")){
            System.out.println("User in Login Page");
            return true;
        }else {
            return false;
        }
    }


}
