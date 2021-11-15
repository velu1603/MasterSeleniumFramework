package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyFirstTestcase {
    @Test
    public void dummyTest(){
        WebDriver driver = new ChromeDriver();
    }
}
