package com.a101.pages;

import com.a101.utility.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    Utility utility;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility = new Utility(driver);
    }

    @FindBy(css = "input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    WebElement searchBox;

    @FindBy(xpath = "//div[contains(text(),'ARA')]")
    WebElement searchButton;

    @FindBy(xpath = "//h3[contains(text(),'Samsung 27\" LS27AG320NUXUF 165Hz 1ms HDMI Dp Frees')]")
    WebElement specificProduct;

    @FindBy(id = "addToCart")
    WebElement addFirstProduct;

    @FindBy(xpath = "//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    WebElement closeNotificationLink;

    @FindBy(xpath = "(//div[@class='addToCart']//button)[2]")
    WebElement addSecondProduct;

    @FindBy(xpath = "//button[.='Sepete git']")
    WebElement goToCartButton;

    @FindBy(xpath = "(//a[.='Samsung 27\" LS27AG320NUXUF 165Hz 1ms HDMI Dp Freesync Va LED M'])[1]")
    WebElement checkFirstProduct;

    @FindBy(xpath = "(//a[.='Samsung 27\" LS27AG320NUXUF 165Hz 1ms HDMI Dp Freesync Va LED M'])[2]")
    WebElement checkSecondProduct;

    public void fillSearchBox(String productName){
        utility.waitForElementPresent(searchBox);
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public void clickSpecificProduct(){
        String originalWindow = driver.getWindowHandle();
        utility.waitForElementPresent(specificProduct);
        specificProduct.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickAddFirstProduct(){
        utility.waitForElementPresent(addFirstProduct);
        addFirstProduct.click();
    }

    public void clickCloseNotificationLink(){
        utility.waitForElementPresent(closeNotificationLink);
        closeNotificationLink.click();
    }

    public void clickAddSecondProduct(){
        utility.waitForElementPresent(addSecondProduct);
        addSecondProduct.click();
    }

    public void clickAddGoToCartButton(){
        utility.waitForElementPresent(goToCartButton);
        goToCartButton.click();
    }

    public boolean verifyIsSelectedCorrect(){
        utility.waitForElementPresent(checkFirstProduct);
        utility.waitForElementPresent(checkSecondProduct);
        if (checkFirstProduct.getText().contains("LS27AG320NUXUF") && checkSecondProduct.getText().contains("LS27AG320NUXUF")){
            System.out.println("Selected Products were correct");
            return true;
        }else {
            return false;
        }
    }

}
