package seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium WebDriver");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).submit();
		System.out.println("Tilte: " + driver.getTitle());
		driver.quit();
		

	}

}
