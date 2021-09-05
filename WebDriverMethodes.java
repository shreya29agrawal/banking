package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class WebDriverMethodes {
	WebDriver driver;
  @Test
  public void WebPage() throws InterruptedException {
	  driver.get("https://www.wikipedia.org/");
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().forward();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  
	  driver.navigate().to("https://in.yahoo.com/");
	   driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     String currentUrl=driver.getCurrentUrl();
	     System.out.println(currentUrl);
	     String sourcePage =driver.getPageSource();
	     System.out.println(sourcePage);
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\OM SAI RAM\\workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
	     driver= new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
