// TestNG Framework

package seleniumframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AmazonTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
	    driver.get("https://www.amazon.in");
	    driver.manage().window().maximize();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
	@Test ( priority = 2)
    public void searchProduct() {
        
        //Wait for search box to be visible
        WebElement searchBox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("mobile");
        
        // Wait for submit button to be clickable
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        submit.click();
        
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("mobile"));

        System.out.println("Title: " + title);
        
	}
	
	@Test ( priority = 1)
		public void searchLaptop() {
		
			//Wait for search box to be visible
			WebElement searchBox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
			searchBox.clear();
			searchBox.sendKeys("Laptop");
        
			// Wait for submit button to be clickable
			WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
			submit.click();

			System.out.println("Title: " + driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Laptop"));
		
	}
	
	@Test ( groups = "Regression")
		public void selectBook() {
			//Wait for dropdown
			WebElement drop = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")));
		
		 	Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		    dropdown.selectByVisibleText("Books");
		    
		    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		    // Enter search text
		    searchBox.clear();
	        searchBox.sendKeys("Java");

	        // Click search button
	        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
	       submit.click();

	        // Print title
	        System.out.println("Title: " + driver.getTitle());
	        Assert.assertTrue(driver.getTitle().contains("Java"));
	}
        
        @AfterMethod
        public void teardown() {
            driver.quit();

        
    }
}