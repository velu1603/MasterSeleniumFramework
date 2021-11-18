package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class MyFirstTestcase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class );
        Product product = new Product(1215);
        StorePage storePage = new HomePage(driver).
                            load().
                            navigateToStoreUsingMenu().
                            search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”" );
        storePage.clickAddToCartBtn(product.getName());
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(
                cartPage.getProductName(),product.getName()
        );
        CheckOutPage checkOutPage = cartPage.
                checkOut().
                setBillingAddress(billingAddress).
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(
                checkOutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }
        @Test
        public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
            String searchFor = "blue";
            BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class );
            Product product = new Product(1215);
            User user = new User("demouser19", "demopwd");
            StorePage storePage = new HomePage(driver).
                    load().
                    navigateToStoreUsingMenu().
                    search(searchFor);
            Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”" );
            storePage.clickAddToCartBtn(product.getName());
            Thread.sleep(5000);
            CartPage cartPage = storePage.clickViewCart();
            Assert.assertEquals(
                    cartPage.getProductName(),product.getName()
            );

            CheckOutPage checkOutPage = cartPage.checkOut();
            checkOutPage.clickHereToLoginLink();

            Thread.sleep(3000);
            checkOutPage.
                    login(user).
                    setBillingAddress(billingAddress).
//                    enterFirstName("demo").
//                    enterLastName("user").
//                    enterAddressLineOne("San Francisco").
//                    enterCity("San Francisco").
//                    enterPostCode("94188").
//                    enterEmail("test1@gmail.com").
                    placeOrder();
            //driver.findElement(By.cssSelector("a[title='View cart']")).click();
            Thread.sleep(5000);
            Assert.assertEquals(
                    checkOutPage.getNotice(),
                    "Thank you. Your order has been received."
            );
        }
}
