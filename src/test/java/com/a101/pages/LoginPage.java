package com.a101.pages;

import com.a101.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    WebDriver driver;
    Utility utility;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility = new Utility(driver);
    }

    @FindBy(id = "btnFacebook")
    WebElement btnFacebook;

    @FindBy(id = "email")
    WebElement fbEmailField;

    @FindBy(id = "pass")
    WebElement fbPasswordField;

    @FindBy(id = "loginbutton")
    WebElement fbLoginButton;

    @FindBy(xpath = "//span[.='Hesabım']")
    WebElement verify;

    public void clickFacebookButton(){
        utility.waitForElementPresent(btnFacebook);
        btnFacebook.click();
    }

    public void enterFacebookEmail(String email){
        utility.waitForElementPresent(fbEmailField);
        fbEmailField.sendKeys(email);
    }

    public void enterFacebookPassword(String password){
        utility.waitForElementPresent(fbPasswordField);
        fbPasswordField.sendKeys(password);
    }

    public void clickFacebookLoginButton(){
        utility.waitForElementPresent(fbLoginButton);
        fbLoginButton.click();
    }

    public boolean isLoginSuccess(){
        utility.waitForElementPresent(verify);
        if (verify.getText().equals("Hesabım")){
            System.out.println("User Login Success");
            return true;
        }else {
            return false;
        }
    }

}
