package genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * Used to maximize the screen
	 * @param driver
	 * @Author Selvi S
	 */
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Used to minimize the screen
	 * @param driver
	 */
	public void minimizeScreen(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Selvi
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //syntax for version 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //version 4
	}
	
	/**
	 * After every action it will wait for next action to perform
	 * @param driver
	 * @author Selvi
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * Used to wait for element to be clickable in GUI and check for specific element for every 500ms
	 * @param driver
	 * @param element

	 * @author Selvi
	 */
	public void waitForElementExplicitWait(WebDriver driver, Duration duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,duration);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				
	}
	
	/**
	 * Used to wait for element to be clickable in GUI and check for specific 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @author Selvi
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialText
	 * @author Selvi
	 */
	
	public void switchWindow(WebDriver driver, String partialText)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		  while(id.hasNext()) 
		  {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
		  }
	}  
	
	/**
	 * Used to switch to AlertWindow and Accept(click on ok button)
	 * @param driver
	 * @author Selvi
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Used to switch to AlertWindow and dismiss(click on cancel button)
	 * @param driver
	 * @author Selvi
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author Selvi S
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * Used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 * @author Selvi S
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 * @author Selvi S
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/**
	 * used to select the value from the dropdown based on value
	 * @param element
	 * @param value
	 * @author Selvi S
	 */
	public void handleDropdown(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	/**
	 * used to select the value from the dropdown based on text
	 * @param element
	 * @param index
	 * @author Selvi S
	 */
	public void handleDropdown(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * Used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author Selvi S
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * author Selvi S
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * used to perform action on offset
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void movebyOffset(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	
	/**
	 * Used to scroll to till the element present
	 * @param driver
	 * @param element
	 */
	public void javaScriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);			
     	
	}
	
	/**
	 * Used to scroll down the web page
	 * @param driver
	 * @param positiveScrollValue
	 * @author Selvi S
	 */
	public void pageScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
	}
	
	
	/**
	 * Used to scroll up the web page
	 * @param driver
	 * @param negativeScrollValue
	 * @author Selvi s
	 */
	public void pageScrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");	
	}
}
