package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtility.WebDriver_Utility;

public class CreateNewContactPage extends WebDriver_Utility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name ="leadsource")
	private WebElement LeadsourceDropDown;
	
	@FindBy(id="title")
	private WebElement titleEdt;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}
	
	
	public WebElement getTitleEdt() {
		return titleEdt;
	}
	
	public WebElement getLeadsourceDropDown() {
		return LeadsourceDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//Business library
	/**
	 * This method will create a new Contact
	 * @param LASTNAME
	 */
	
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create a new contact with Organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LASTNAME, String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchWindow(driver, "Contacts");
		SaveBtn.click();
	}
}
