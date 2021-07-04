package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Page_UI.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePageFactory{
	private WebDriver driver;

	public MyAccountPageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH,using="//input[@id='gender-male']")
	WebElement genderMailRadio;
	
	@FindBy(how = How.XPATH,using="//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(how = How.XPATH,using="//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(how = How.XPATH,using="//select[@name='DateOfBirthDay']")
	WebElement dayDropDown;
	
	@FindBy(how = How.XPATH,using="//select[@name='DateOfBirthMonth']")
	WebElement monthDropDown;
	
	@FindBy(how = How.XPATH,using="//select[@name='DateOfBirthYear']")
	WebElement yearDropDown;
	
	@FindBy(how = How.XPATH,using="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(how = How.XPATH,using="//input[@id='Company']")
	WebElement companyTextbox;
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver, genderMailRadio);
		return isElementIsSelect(genderMailRadio);
		
	}

	public String getFirstNameTexboxValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getAttributeValue(firstNameTextbox, "value");
	}

	public String getLastNameTexboxValue() {
		
		waitForElementVisible(driver, lastNameTextbox);
		return getAttributeValue(lastNameTextbox, "value");
		
	}

	public String getEmailTexboxValue() {
		
		waitForElementVisible(driver, emailTextbox);
		return getAttributeValue(emailTextbox, "value");
		
	}

	public String getCompanyNameTexboxValue() {
		waitForElementVisible(driver, companyTextbox);
		return getAttributeValue(companyTextbox, "value");
		
	}

	public String getDayDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, dayDropDown);
		return getFirstSelectItemInDropdown(dayDropDown);
	  
	}

	public String getMonthDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, monthDropDown);
		return getFirstSelectItemInDropdown(monthDropDown);
		
	}	

	public String getYearDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, yearDropDown);
		return getFirstSelectItemInDropdown(yearDropDown);
		
	}
	

}
