package miscelleniouspack;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario3 {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	Date d=new  Date();
	
	System.out.println(d.getDate());
}
}
