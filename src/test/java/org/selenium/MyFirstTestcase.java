package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestcase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.search("Blue");//
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”" );
        storePage.clickAddToCartBtn("Blue Shoes");
        //driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        //driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(
                cartPage.getProductName(),"Blue Shoes"
        );
        CheckOutPage checkOutPage = cartPage.clickCheckoutBtn();
        //driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("demo");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("user");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("San Francisco");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94188");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("test1@gmail.com");
        driver.findElement(By.cssSelector("#place_order")).click();
        Thread.sleep(5000);
        Assert.assertEquals(
                driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );
    }
        @Test
        public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException {
            driver.get("https://askomdch.com");
            driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
            driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("blue");
            driver.findElement(By.cssSelector("button[value='Search']")).click();
            Assert.assertEquals(
                    driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
                    "Search results: “blue”"
            );
            driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("a[title='View cart']")).click();
            Assert.assertEquals(
                    driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                    "Blue Shoes"
            );
            driver.findElement(By.cssSelector(".checkout-button")).click();
            driver.findElement(By.className("showlogin")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("username")).sendKeys("demouser19");
            driver.findElement(By.id("password")).sendKeys("demopwd");
            driver.findElement(By.name("login")).click();
            driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("demo");
            driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("user");
            driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("San Francisco");
            driver.findElement(By.cssSelector("#billing_city")).sendKeys("San Francisco");
            driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94188");
            driver.findElement(By.cssSelector("#billing_email")).clear();
            driver.findElement(By.cssSelector("#billing_email")).sendKeys("test1@gmail.com");
            driver.findElement(By.cssSelector("#place_order")).click();
            Thread.sleep(5000);
            Assert.assertEquals(
                    driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),
                    "Thank you. Your order has been received."
            );
        }
}
