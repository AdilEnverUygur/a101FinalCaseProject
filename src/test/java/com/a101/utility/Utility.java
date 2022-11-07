package com.a101.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {

    WebDriver driver;

    private int timeOut = Integer.parseInt(ReadFromFile.readConfigProperties("timeOut"));

    //Class Constructor
    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    //Method that waiting for element present
    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Sleep method
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
