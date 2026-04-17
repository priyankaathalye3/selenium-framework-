// Drop down handling and waits

package seleniumframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		  
		// Wait for page load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

	    // Enter search text
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[contains(@id,'nav-search-submit-button')]")).click();
		
		System.out.println("Title is: " + driver.getTitle());
		
	
        
        // Dropdown handling, task1
		
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
        
        
        //Task 2 : Re-locate dropdown after page reload
       
      
        Select dropdown2 = new Select(driver.findElement(By.id("searchDropdownBox")));
        dropdown2.selectByVisibleText("Electronics");
        Thread.sleep(3000);
        // Clear the field before search
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");
        driver.findElement(By.id("nav-search-submit-button")).click();
        
        Thread.sleep(3000);
        
        // Print current url
        System.out.println("Current url is:" + driver.getCurrentUrl());
		
		
		driver.quit();
		

	}

}
