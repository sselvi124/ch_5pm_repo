package miscelleniouspack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario1MakeMyTripe {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	driver.findElement(By.xpath("(//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Body']/descendant::p[text()='3'])[1]")).click();
}
}
