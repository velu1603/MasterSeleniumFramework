package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.contants.DriverType;

public class DriverManager {

    public WebDriver initializeDriver(String browser){
       WebDriver driver;
       switch (DriverType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                 driver = new ChromeDriver();
                 break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver= new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name");
        }
//        WebDriverManager.chromedriver().cachePath("Drivers").setup();
//        WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
        return driver;
    }
}
