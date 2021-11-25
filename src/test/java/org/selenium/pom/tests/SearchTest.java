package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){
        String searchFor = "blue";
        StorePage storePage = new StorePage(getDriver()).
                load().search(searchFor);
        //Assert.assertEquals();
        storePage.urlContains(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”" );


    }
}
