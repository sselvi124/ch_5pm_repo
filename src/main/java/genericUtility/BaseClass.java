package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;


public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver; //only for listeners for give driver ref
	
	@BeforeSuite (alwaysRun=true)
	public void beforeSuite() {
		System.out.println("Database Connection");
	}
	
	@BeforeTest (groups = "SmokeSuite")
	public void beforTest() {
		System.out.println("Parallel Execution");
	}
	
	@Parameters("BROWSER")
//@BeforeTest(alwaysRun=true)
	@BeforeClass(alwaysRun=true)
public void beforeClass(String BROWSER)throws Throwable
//	public void beforeClass() throws Throwable
	
	{
		File_Utility flib= new File_Utility();
		
	//	String BROWSER = flib.getStringKeyAndValue("browser");
		
		//run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		System.out.println("Launching browser");	
		
		sdriver= driver; // for listener only we can call with class name.sdriver	
	}
	

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Throwable {
		
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		String URL=flib.getStringKeyAndValue("url");
		String USERNAME=flib.getStringKeyAndValue("username");
		String PASSWORD=flib.getStringKeyAndValue("password");
		
		driver.get(URL);
		wlib.maximizeScreen(driver);
		wlib.waitForPageToLoad(driver);
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

		System.out.println("Login to application");
		
	}
	
	@AfterMethod(groups = { "SmokeSuite","regressionTest"})
	public void afterMethod() {
		HomePage home = new HomePage(driver);
		home.Logout(driver);
		
		System.out.println("Logout");
	}
	
	@AfterClass(groups = { "SmokeSuite","regressionTest"})
	public void afterClass() {
		driver.close();
		System.out.println("browser closed");
	}

	@AfterTest(groups = { "SmokeSuite","regressionTest"})
	public void afterTest() {
		System.out.println("parallel execution done");
	}
	
	
	@AfterSuite(groups = { "SmokeSuite","regressionTest"})
	public void afterSute() {
		System.out.println("db closed"); 
	} 
		
}


