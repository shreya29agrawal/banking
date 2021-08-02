package scripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
	
		WebDriver driver;
		WebDriverWait myWait;
		  @Test
		  public void loadPage() throws InterruptedException {
			  
			  driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		
			  driver.findElement(By.xpath("//button[text()='Start']")).click();
			//  WebElement hello =  driver.findElement(By.xpath("//h4[text()='Hello World!']"));
			//  myWait.until(ExpectedConditions.visibilityOf(hello));
			
			  // always prefered by locator in explicit wait
			  myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
			  
			String actual =  driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
			//System.out.println(actual.getText());
			  String expected = "Hello World!";
			assertEquals( actual, expected);
			  
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\OM SAI RAM\\workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
		     driver= new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			  // myWait = new WebDriverWait(driver,10);
			  // polling intervel 500 mili second
			  // we can change it in explict wait by providing the limit
			  myWait = new WebDriverWait(driver,10,300);
			  
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}
