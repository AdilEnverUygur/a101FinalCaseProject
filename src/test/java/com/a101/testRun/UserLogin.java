package com.a101.testRun;

import com.a101.logger.Log;
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

   //Global objects and variable
   HomePage homePage;
   LoginPage loginPage;
   ProductPage productPage;
   Utility utility;
   String url = ReadFromFile.readConfigProperties("url");

    /**
     * Setup browser and navigate hepsiburade website
     * Object creation and identify the driver
     */
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        setUpBrowser(url);
        Log.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder.");
        Log.info("Çerezler Kabul Edildi");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage=new ProductPage(driver);
        utility = new Utility(driver);
    }

    /**
     * Close Cookie and go to the login page
     */
    @Test
    public void homePageSteps(){
        homePage.clickAcceptHandler();
        homePage.moveToDropDownList();
        homePage.clickLoginLink();
        Assert.assertTrue(homePage.isInLoginPage());
    }

    /**
     * Do login operation
     */
    @Test()
    public void loginPageSteps(){
        Log.info("Kullanıcı giriş işlemi yapılır.");
        loginPage.clickFacebookButton();
        loginPage.enterFacebookEmail(ReadFromFile.readConfigProperties("username"));
        loginPage.enterFacebookPassword(ReadFromFile.readConfigProperties("password"));
        loginPage.clickFacebookLoginButton();
        Assert.assertTrue(loginPage.isLoginSuccess());
        Log.info("Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulandı");
    }

    /**
     * Search specific product and add to cart from two seller
     * then verify the selected product is correct.
     */
    @Test
    public void productPageSteps(){
        productPage.fillSearchBox(ReadFromFile.readConfigProperties("productName"));
        Log.info("Kullanıcı, burada satın almak istediği ürün için arama yaptı.");
        productPage.clickSearchButton();
        productPage.clickSpecificProduct();
        Log.info("Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden ürün seçti.");
        productPage.clickAddFirstProduct();
        productPage.clickCloseNotificationLink();
        productPage.clickAddSecondProduct();
        Log.info("Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklendi.");
        productPage.clickAddGoToCartButton();
        Log.info("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdı.");
        Assert.assertTrue(productPage.verifyIsSelectedCorrect());
        Log.info("Test Başarılı oldu");

    }

    //Close chrome
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        teardown();
    }

}
