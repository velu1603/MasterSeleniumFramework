package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class MyFirstTest extends BaseTest {
   @Test
    public void guestCheckOutUsingDirectBankTransfer() throws IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class );
        Product product = new Product(1215);
        StorePage storePage = new HomePage(getDriver()).
                            load().
                            getMyHeader().navigateToStoreUsingMenu().
                            search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”" );
        //org.junit.Assert.assertEquals("Search results: “"+searchFor+"”",storePage.getTitle());
        storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),product.getName());
        //org.junit.Assert.assertEquals(product.getName(), cartPage.getProductName());
        CheckOutPage checkOutPage = cartPage.
                checkOut().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
       Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
        //org.junit.Assert.assertEquals("Thank you. Your order has been received.", checkOutPage.getNotice());
    }
       @Test
        public void loginAndCheckOutUsingDirectBankTransfer() throws IOException {
            String searchFor = "blue";
            BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class );
            Product product = new Product(1215);
            User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
            StorePage storePage = new HomePage(getDriver()).
                    load().
                    getMyHeader().navigateToStoreUsingMenu().
                    search(searchFor);
           Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”" );
           // org.junit.Assert.assertEquals("Search results: “"+searchFor+"”",storePage.getTitle());
            storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
            CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
            Assert.assertEquals(cartPage.getProductName(),product.getName());
            //org.junit.Assert.assertEquals(product.getName(), cartPage.getProductName());
            CheckOutPage checkOutPage = cartPage.checkOut();
            checkOutPage.clickHereToLoginLink();
            checkOutPage.
                    login(user).
                    setBillingAddress(billingAddress).
                    selectDirectBankTransfer().
                    placeOrder();
            Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
            //org.junit.Assert.assertEquals("Thank you. Your order has been received.", checkOutPage.getNotice());
        }

        //@Test
        public void testForExperiment(){
            System.out.println("Just a dummy test case");
            Assert.assertEquals(1,1);
            //Assert.assertEquals(1,1);
        }
}
