package org.selenium.pom.base;

import io.restassured.http.Cookies;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.utils.CookieUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;

public class BaseTest {
   private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //protected WebDriver driver;
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return  this.driver.get();
    }


    @Parameters("browser")
    @BeforeMethod
    //@Before
    public synchronized void startDriver(String browser){
        browser = System.getProperty("browser", browser);
       // String browser = "CHROME";
        //setDriver(new DriverManager().initializeDriver(browser));
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("CURRENT THREAD "+ Thread.currentThread().getId() + ", "
            + "DRIVER = " + getDriver());

    }

    @AfterMethod
    //@After
    public synchronized void quitDriver()    {
        System.out.println("CURRENT THREAD "+ Thread.currentThread().getId() + ", "
                + "DRIVER = " + getDriver());
        getDriver().quit();
        //driver.quit();
    }

    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie : seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }

    }
}
