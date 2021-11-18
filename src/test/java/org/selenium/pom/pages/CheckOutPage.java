package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckOutPage extends BasePage {

    private final By firstnameFld = By.id("billing_first_name");
    private final By lastnameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By clickHereToLogin = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName){
        driver.findElement(firstnameFld).clear();
        driver.findElement(firstnameFld).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastnameFld).clear();
        driver.findElement(lastnameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
            return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());

    }

    public CheckOutPage placeOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return driver.findElement(successNotice).getText();
    }

    public CheckOutPage clickHereToLoginLink(){
        driver.findElement(clickHereToLogin).click();
        return this;
    }

    public CheckOutPage enterUserName(String username){
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckOutPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckOutPage login(User user){
        return enterUserName(user.getUsername()).
                enterPassword(user.getPassword()).
                clickLoginBtn();
    }

}
