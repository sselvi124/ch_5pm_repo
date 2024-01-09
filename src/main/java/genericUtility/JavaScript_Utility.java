package genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript_Utility {
JavascriptExecutor js;
	
	/**
	 * @param driver
	 * @return 
	 */
	public void JavaScriptUtility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeAsyncScript("window.location=arguments[0]", url);
	}
	
	/**
	 * @param element
	 * @param data
	 */
	public void sendkeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * @param element
	 * 
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);		
	}
	
	/**
	 * @return
	 */
	public String getUrlOfCurrentPage()
	{
		String url =(String) js.executeScript("return window.location.href");
		return url;
	}
	
	/**
	 * @return
	 */
	public String getTitleOfCurrentPage()
	{
		String title =(String) js.executeScript("return document.title");
		return title;
	}
	
	/**
	 * 
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/**
	 * 
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void javaScriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

}
