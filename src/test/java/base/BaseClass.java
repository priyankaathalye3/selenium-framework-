package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utils.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	ConfigReader config;
	
	@Parameters("browser")    // to support parallel execution in different browsers
    @BeforeMethod
    public void setup(String browser) {
    	
    	config = new ConfigReader();
    	
    	//String browser = config.getProperty("browser");  removing as this will not support parallel execution

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
        	   System.setProperty("webdriver.edge.driver", "F:\\Automation 2026\\msedgedriver.exe");   //  actual path
        	
            driver = new EdgeDriver();
        }
        
        driver.get(config.getProperty("url"));
        
		// driver.get("https://www.amazon.com/");  old
		driver.manage().window().maximize();
	}
    
    public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + testName + ".png");
            FileHandler.copy(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {

	    if (ITestResult.FAILURE == result.getStatus()) {
	        takeScreenshot(result.getName());
	        
	        System.out.println("Screenshot taken for failed test: " + result.getName());
	    }

	    driver.quit();
	}

}
