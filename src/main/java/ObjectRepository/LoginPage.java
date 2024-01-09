package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(xpath="//input[@name='user_name']")
		private WebElement userNameTextField;
		
		@FindBy(name="user_password")
		private WebElement passWordTextField;
		
		@FindBy(id="submitButton")
		private WebElement loginbutton;
		

		
		//getter methods
		public WebElement getUserNameTextField() {
			return userNameTextField;
		}

		public WebElement getPassWordTextField() {
			return passWordTextField;
		}

		public WebElement getLoginbutton() {
			return loginbutton;
		}

	//create business logic (methods)
		
		/**
		 * this method is use to login to the application using valid credential
		 * @param userName
		 * @param Password
		 * @author Selvi S
		 */
		public void loginToApp(String userName, String Password)
		{
			userNameTextField.sendKeys(userName);
			passWordTextField.sendKeys(Password);
			loginbutton.click();
		}
		
		
}
