package com.a101.testRun;

import com.a101.pages.HomePage;
import com.a101.pages.LoginPage;
import com.a101.pages.ProductPage;
import com.a101.utility.BasePage;
import com.a101.utility.ReadFromFile;
import com.a101.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserLogin extends BasePage {

   HomePage homePage;
   LoginPage loginPage;
   ProductPage productPage;
   Utility utility;
   String url = ReadFromFile.readConfigProperties("url");

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        setUpBrowser(url);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage=new ProductPage(driver);
        utility = new Utility(driver);
    }

    @Test
    public void homePageSteps(){
        homePage.clickAcceptHandler();
        homePage.moveToDropDownList();
        homePage.clickLoginLink();
        Assert.assertTrue(homePage.isInLoginPage());
    }

    @Test()
    public void loginPageSteps(){
        loginPage.clickFacebookButton();
        loginPage.enterFacebookEmail(ReadFromFile.readConfigProperties("username"));
        loginPage.enterFacebookPassword(ReadFromFile.readConfigProperties("password"));
        loginPage.clickFacebookLoginButton();
        Assert.assertTrue(loginPage.isLoginSuccess());
    }

    @Test
    public void productPageSteps(){
        productPage.fillSearchBox(ReadFromFile.readConfigProperties("productName"));
        productPage.clickSearchButton();
        productPage.clickSpecificProduct();
        productPage.clickAddFirstProduct();
        productPage.clickCloseNotificationLink();
        productPage.clickAddSecondProduct();
        productPage.clickAddGoToCartButton();
        Assert.assertTrue(productPage.verifyIsSelectedCorrect());

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        teardown();
    }

}
