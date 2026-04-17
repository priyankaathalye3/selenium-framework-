// Alerts

package seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Print an accept alert
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		//Switch to alert and accept
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// Alert2 :Dismiss alert
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
		// Alert3 : enter text and accept
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		String text2= driver.switchTo().alert().getText();
		System.out.println(text2);
		// Enter text
		driver.switchTo().alert().sendKeys("Hello");
		// Accept alert
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		// Verify result on page
		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Result message: " + result);
	

		
		driver.quit();
		
		

	}

}
