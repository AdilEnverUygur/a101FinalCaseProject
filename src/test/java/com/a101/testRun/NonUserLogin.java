package com.a101.testRun;

import com.a101.pages.HomePage;
import com.a101.pages.ProductPage;
import com.a101.utility.BasePage;
import com.a101.utility.ReadFromFile;
import com.a101.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NonUserLogin extends BasePage {

   HomePage homePage;
   ProductPage productPage;
   Utility utility;
   String url = ReadFromFile.readConfigProperties("url");

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        setUpBrowser(url);
        homePage=new HomePage(driver);
        productPage=new ProductPage(driver);
        utility = new Utility(driver);
    }


    @Test
    public void productPageSteps(){
        homePage.clickAcceptHandler();
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
