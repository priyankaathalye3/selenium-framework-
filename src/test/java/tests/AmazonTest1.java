package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AmazonPage;

public class AmazonTest1 extends BaseClass{

    AmazonPage amazon;
    
    // Create data provider
    @DataProvider(name = "searchData")
    public Object[][] getData() {
        return new Object[][] {
            {"mobile"},
            {"laptop"},
            {"headphones"}
        };
    }
        

    @Test (dataProvider = "searchData" )
    public void searchMobile(String product) {
    	
    	amazon = new AmazonPage(driver);
    	
        amazon.enterSearchText(product);
        amazon.clickSearch();

        System.out.println("Searching for:" + product);
        
        String title= amazon.getTitle();
        System.out.print(title);
        
        Assert.assertTrue(amazon.getTitle().contains(product));
        //Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test (priority =2 )
    public void searchBooks() {
    	amazon = new AmazonPage(driver);
 
        amazon.selectCategory("Books");
        amazon.enterSearchText("Java");
        amazon.clickSearch();

        String title= amazon.getTitle();
        System.out.print(title);
        Assert.assertTrue(amazon.getTitle().contains("Java"));
        //Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

   
}