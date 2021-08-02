package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FirstTestNGTest {
	
	WebDriver driver;
  @Test
  public void wikiTest() {
	  // all test steps go here
	  driver.get("https://www.wikipedia.org/");
	  WebElement englishLink = driver.findElement(By.id("js-link-box-en"));
	     englishLink.click();
	    // driver.findElement(By.id("js-link-box-en")).click();
	     
	     driver.findElement(By.id("searchInput")).sendKeys("Selenium") ;
	     driver.findElement(By.id("searchButton")).click();
	     //driver.findElement(By.id("searchInput")).findElement(By.id("searchButton"));
	     // for heading of page
	     String expectedOutput="Selenium";
	    
	     String actualOutput=driver.findElement(By.id("firstHeading")).getText();
	     System.out.println(actualOutput);
	     assertEquals(expectedOutput,actualOutput);
	     
	     if(expectedOutput.equals(actualOutput))
	     {
	    	 System.out.println("test pass heading match");
	     }
	     else
	     {
	    	 System.out.println("test fail heading not match");
	     }
	     
	// to check titel of page
	     String title=driver.getTitle();
	     
	     System.out.println(title);
	     String expTitle= "Selenium - Wikipedia";
	     assertEquals(title,expTitle);
	     
	     if(title.equals(expTitle))
	     { System.out.println("correct output Title match");}
	     else
	    	 {System.out.println("output missmatch titel not match");}
}
	@Test
	public void googleTest()
	{
		driver.get("https://www.google.com");
		driver.findElement(By.linkText("Gmail")).click();
		//driver.findElement(By.name("q")).sendKeys("selenium tutorial");
	}
	@Test
	public void amazonTest()
	{
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
  
  @BeforeMethod
  public void beforeMethod() {
	  // pre-requisite case here 
	  // like open the browser
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\OM SAI RAM\\workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
	     driver= new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  // test case cleanup will go here 
	  // eg. close the browser
	  driver.close();
  }

}
