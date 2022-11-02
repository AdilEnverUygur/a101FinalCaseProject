package com.a101.testRun;

import com.a101.logger.Log;
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
        Log.info("Kullanıcı Hepsiburada.com sitesini ziyaret eder.");
        homePage=new HomePage(driver);
        productPage=new ProductPage(driver);
        utility = new Utility(driver);
    }


    @Test
    public void productPageSteps(){
        homePage.clickAcceptHandler();
        Log.info("Çerezler Kabul Edildi");
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

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        teardown();
    }

}
