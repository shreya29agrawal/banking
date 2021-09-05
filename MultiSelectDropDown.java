package scripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiSelectDropDown {
	WebDriver driver;
  @Test
  public void multiselectDropDown() throws InterruptedException {
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  WebElement colorDropdown=driver.findElement(By.name("color"));
	  Select  color = new Select(colorDropdown);
	  color.selectByIndex(2);
	  Thread.sleep(1000);
	  color.selectByVisibleText("Silver");
	  Thread.sleep(1000);
	  color.selectByValue("bl");
	  Thread.sleep(1000);
	  
	 
	  int optionCount = color.getAllSelectedOptions().size();
	  System.out.println("total selected color is "+optionCount);
	  
	  List<WebElement> colorName = color.getAllSelectedOptions();
	  
	  for(WebElement selected : colorName)
	  {
		  System.out.println("all selected color is :"+selected.getText());
	  }
	  
	 /* WebElement option = color.getFirstSelectedOption();
	  System.out.println(option.getText());*/
	  
	  // deselecting option 
	  
	  color.deselectByIndex(2);
	  Thread.sleep(1000);
	  color.deselectByVisibleText("Silver");
	  Thread.sleep(1000);
	  color.deselectByValue("bl");
	  Thread.sleep(1000);
	  
	  // deselecting all
	 
	  
	  color.deselectAll();
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
