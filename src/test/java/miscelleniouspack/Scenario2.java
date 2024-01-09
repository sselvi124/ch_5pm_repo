package miscelleniouspack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	for(int i=1;i<=4;i++) {
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	} 
	try {
				
	WebElement Date = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/descendant::p[text()='3']"));
	Date.click();
	Actions act = new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	
	//driver.findElement(By.xpath("//a[@class='close']")).click();
	//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	
	}
	catch(Exception e) {
		System.out.println("not in expected page");
	}
	}
}
