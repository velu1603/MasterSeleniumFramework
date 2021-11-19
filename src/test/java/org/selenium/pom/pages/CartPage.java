package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkOutBtn = By.cssSelector(".checkout-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
        }

    public CheckOutPage checkOut(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
        return new CheckOutPage(driver);
    }
}
