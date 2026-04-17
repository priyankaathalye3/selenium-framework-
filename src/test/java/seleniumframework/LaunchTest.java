package seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        // Maximize window
        driver.manage().window().maximize();

        // Enter text in search box
        driver.findElement(By.name("q")).sendKeys("Selenium");

        // Wait (temporary)
        Thread.sleep(2000);

        // Press Enter
        driver.findElement(By.name("q")).submit();

        Thread.sleep(3000);

        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}