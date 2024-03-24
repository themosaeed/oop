package trail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTests extends BaseTest {



    String expectedPrice = "$15.99";


    @Test
    public void validateProductPrice(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user","secret_sauce");
        homePage.openProduct();
        String actualValue = driver.findElement(productPage.getProdcutPrice()).getText();
        Assert.assertEquals(actualValue, expectedPrice);
    }

    @Test
    public void addProductToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartpage = new CartPage(driver);


        loginPage.login("standard_user","secret_sauce");
        homePage.openProduct();
        productPage.addToCart();
        productPage.moveToCartPage();
        boolean isElementDisplayed = driver.findElement(cartpage.getProductName()).isDisplayed();
        Assert.assertTrue(isElementDisplayed);

    }




}
