package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");
    private final By directBankTransferRadioButton = By.id("payment_method_bacs");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage selectCountry(String countryName){
        Select select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);
        return this;
    }


    public CheckOutPage enterFirstName(String firstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameFld));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameFld));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
        e.clear();
        e.sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckOutPage selectState(String stateName){
        Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));
        e.clear();
        e.sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
            return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());

    }

    public CheckOutPage placeOrder(){
        waifForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice));
        return e.getText();
    }

    public CheckOutPage clickHereToLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(clickHereToLogin)).click();
        return this;
    }

    public CheckOutPage enterUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
        //driver.findElement(usernameFld).sendKeys(username);
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

    public CheckOutPage selectDirectBankTransfer(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioButton));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

}
