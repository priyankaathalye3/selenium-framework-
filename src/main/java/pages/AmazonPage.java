package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPage {

    WebDriver driver;
   
    WebDriverWait wait;
    // Constructor
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");
    By dropdown = By.id("searchDropdownBox");

    // Actions
    public void enterSearchText(String text) {
    	 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 
    	 WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    	 searchBox.clear();
    	 searchBox.sendKeys(text);
    }

    public void clickSearch() {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))
        );

        btn.click();
    }

    public void selectCategory(String value) {
    	
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")));
    	
    	Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    	
    	/*
        new org.openqa.selenium.support.ui.Select(
            driver.findElement(dropdown)
        ).selectByVisibleText(value);
        
        */
    }
    
    
    // method for assertions
    public String getTitle() {
    	return driver.getTitle();
    }
}