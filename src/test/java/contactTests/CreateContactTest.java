package contactTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtility.BaseClass;
import genericUtility.File_Utility;
import genericUtility.Java_Utility;
import genericUtility.WebDriver_Utility;
import genericUtility.iPathConstant;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtility.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{

@Test
 public void createContctTest() throws Throwable {
		
		Java_Utility jUtil=new Java_Utility();
		  int ranNum = jUtil.getRandomNum();
		  	  
		  WebDriver_Utility wUtil = new WebDriver_Utility(); 
		  File_Utility fUtil =new File_Utility();
		  
		HomePage hp= new HomePage(driver);
	
		hp.getContactsLink().click();
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnContactsLookUpImage();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		
	//	Assert.fail(); // for fail the script
		
		cncp.createNewContact("spiderman"+ranNum);
	
		
	/*	
		Random r = new Random();
		int ranNo=r.nextInt(1000);
		System.out.println(ranNo);

	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//click on contact
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("spiderman"+ranNo);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	*/
}
}
