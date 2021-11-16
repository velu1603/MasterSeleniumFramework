package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckOutPage extends BasePage {

    private final By firstnameFld = By.id("billing_first_name");
    private final By lastnameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName){
        driver.findElement(firstnameFld).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastnameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode){
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public String getNotice(){
        return driver.findElement(successNotice).getText();
    }


}
