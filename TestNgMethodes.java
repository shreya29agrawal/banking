package scripts;
/*before suite - set up system property for chrome
before test login to app
before class -launch chrome browser
befor methode enter url
test case happened here 
after the methode close web page
after class logout from app
after test close web browser
PASSED: f
 
 * 
 */
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgMethodes {
	@BeforeSuite // 1
	  public void beforeSuite() {
		System.out.println("before suite - set up system property for chrome");
	  }
	
	@BeforeTest //2
	  public void beforeTest() {
		 System.out.println("before test login to app");
	  }
	 @BeforeClass//3
	  public void beforeClass() {
		 System.out.println("before class -launch chrome browser");
	  }
	 
	 @BeforeMethod//4
	  public void beforeMethod() {
		 System.out.println("befor methode enter url");
	  }
	 
  @Test//5
  public void f() {
	  System.out.println("test case happened here ");
  }
  

  @AfterMethod //6
  public void afterMethod() {
	  System.out.println("after the methode close web page");
  }

 

  @AfterClass//7
  public void afterClass() {
	  System.out.println("after class logout from app");
  }

 

  @AfterTest //8
  public void afterTest() {
	  System.out.println("after test close web browser");
  }

  @AfterSuite//9
  public void afterSuite() {
	  System.out.println("close system propertty");
  }

}
