package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchField(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(text);
        //WebElement e = waitForElementToBeVisible(searchField);
        //e.sendKeys(text);
        return this;
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    private StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }

    public StorePage search(String txt){
        enterTextInSearchField(txt).clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public StorePage urlContains(String UrlContains){
        wait.until(ExpectedConditions.urlContains(UrlContains));
        return this;
    }

    private By getAddToCardBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public StorePage clickAddToCartBtn(String productName){
        By addToCardBtn = getAddToCardBtnElement(productName);
        driver.findElement(addToCardBtn).click();
        return this;
    }

    public CartPage clickViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        //driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }



}
