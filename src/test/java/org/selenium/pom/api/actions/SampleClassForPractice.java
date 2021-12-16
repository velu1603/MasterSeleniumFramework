package org.selenium.pom.api.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleClassForPractice {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.theworldsworstwebsiteever.com/tipz.php");
        //WebElement tipText = driver.findElement(By.cssSelector("div > p +p"));
       WebElement tipText = driver.findElement(By.xpath("//p[strong[text()='TIP:']]//following::p[not(a) and not(script)]"));
        System.out.println(tipText.getText());
        driver.quit();

    }
}
