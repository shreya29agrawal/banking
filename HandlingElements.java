package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class HandlingElements {
	WebDriver driver;
  @Test
  public void cookBook() throws InterruptedException {
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  WebElement airbags= driver.findElement(By.name("airbags"));
	  
	  /*
		 * checkbox
			- select/check - click()
			- unselect/uncheck - click()
			- whether the checkbox is checked or not - isSelected()
			- Always check whether it is selected or not and then accordingly click or do not click
		 */
	  
	  		if(!airbags.isSelected())
	  			airbags.click();
	  		Thread.sleep(3000);
	  		if(airbags.isSelected())
	  			airbags.click();
	  		Thread.sleep(3000);
	  		
	  		/*
			 * radio 
				- select/check - click()
				- whether the radi is selected or not - isSelected() - may not be required unless you want to take different actions based on this. 
				- It  is not required check whether it is selected or not
			 */
	  		
	  		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
	  		Thread.sleep(3000);
	  		
	  			
  }
  
  @Test
  public void cookBookDropDown() throws InterruptedException {
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  WebElement makeDropdown=driver.findElement(By.name("make"));
	  Select  make = new Select(makeDropdown);
	  List<WebElement> allOptions=make.getOptions();
	  int noOfOption=make.getOptions().size();
	  List<String> expectedOption = new ArrayList<String>();
	  expectedOption.add("BMW");
	  expectedOption.add("Mercedes");
	  expectedOption.add("Audi");
	  expectedOption.add("Honda");
	  
	  List<String> actualoption = new ArrayList<String>();
	  for(WebElement oneOption :allOptions )
	  { actualoption.add(oneOption.getText());
		  
	  }
	  assertEquals(actualoption,expectedOption);
	  Thread.sleep(2000);
	  make.selectByVisibleText("Audi");
		Thread.sleep(2000);
		make.selectByValue("honda");
		Thread.sleep(2000);
		make.selectByIndex(1);
		Thread.sleep(2000);
		
		String currentExpectedOptionText = "Mercedes";
		
		String currentActualOptionText = make.getFirstSelectedOption().getText();
		
		assertEquals(currentActualOptionText, currentExpectedOptionText);

	  
	  
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
