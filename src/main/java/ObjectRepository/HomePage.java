package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtility.WebDriver_Utility;

public class HomePage {
	//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
		//Declaration
		@FindBy(linkText="Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText="Products")
		private WebElement productsLink;
		
		@FindBy(linkText="Contacts")
		private WebElement contactsLink;
		
		
		@FindBy(linkText="More")
		private WebElement moreLink;
		
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignsLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signoutlink;
		
		
		//getter method
		public WebElement getorganizationLink() {
			return organizationLink;
		}
		
		public WebElement getproductsLink() {
			return productsLink;
		}
		
		public WebElement getContactsLink() {
			return contactsLink;
		}
		
		public WebElement getMoreLink() {
			return moreLink;
		}


		public WebElement getcampaignsLink() {
			return campaignsLink;
		}

		public WebElement getadministratorImg() {
			return administratorImg;
		}

		public WebElement getSignoutlink() {
			return signoutlink;
		}

		
		//Business Logic
		/**
		 * This method is used to click the "ORGANIZATIONS" module link
		 * author Selvi S
		 */
		public void clickOrganizationLink()
		{
			organizationLink.click();
		}
		
		/**
		 * This method is used to click the "PRODUCTS" module link
		 * author Selvi S
		 */
		public void clickProductsLink()
		{
			productsLink.click();
		}
		
		/**
		 * This method is used to click the "PRODUCTS" module link
		 * author Selvi S
		 */
		public void clickContactsLink()
		{
			contactsLink.click();
		}
		
		/**
		 * This method is used to click the "MORE" module link
		 * author Selvi S
		 */
		public void clickMoreLink()
		{
			moreLink.click();		
		}
		
		/**
		 * This method is used to click the "CAMPAIGNS" module link
		 * author Selvi S
		 */
		public void clickCampaignsLink()
		{
			campaignsLink.click();
		}
		
		/**
		 * This method is used to sign out the application
		 * @param driver
		 */
		public void Logout(WebDriver driver)
		{
			WebDriver_Utility wUtil = new WebDriver_Utility(); 
			wUtil.mouseOverOnElement(driver, administratorImg);		
		//	Actions act = new Actions(driver);
		//	act.moveToElement(logoutImag);		
			signoutlink.click();	
		}	
}
