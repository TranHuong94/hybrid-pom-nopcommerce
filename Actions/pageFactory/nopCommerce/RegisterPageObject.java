package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Page_UI.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	
	public RegisterPageObject( WebDriver _driver) {
	
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//input[@id='gender-male']")
	WebElement genderMailRadio;
	
	@FindBy(how=How.XPATH, using="//input[@id='FirstName']")
	WebElement fistNameTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(how=How.XPATH, using="//select[@name='DateOfBirthDay']")
	WebElement dayDropDown;
	
	@FindBy(how=How.XPATH, using="//select[@name='DateOfBirthMonth']")
	WebElement monthDropDown;
	
	@FindBy(how=How.XPATH, using="//select[@name='DateOfBirthYear']")
	WebElement yearDropDown;
	
	@FindBy(how=How.XPATH, using="//input[@id='Email']")
	WebElement emailTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@id='Company']")
	WebElement companyTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(how=How.XPATH, using="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordTextbox;
	
	@FindBy(how=How.XPATH, using="//button[@id='register-button']")
	WebElement registerButton;
	
	@FindBy(how=How.XPATH, using="//div[@class='result' and text()= 'Your registration completed']")
	WebElement registerSuccessMassage;
	
	@FindBy(how=How.XPATH, using="//a[@class='ico-logout']")
	WebElement logoutLink;
	
	public void clikToGenderMaleRadio() {
		waitForElementClickable(driver, genderMailRadio);
		genderMailRadio.click();
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, fistNameTextBox);
		sendkeyToElement(driver, fistNameTextBox, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
		
	}

	public void selectMonthDropdown(String day) {
		waitForElementVisible(driver,monthDropDown);
		selectItemInDefaulDropdown(monthDropDown, day);
		
	}

	public void selectDayDropdown(String month) {
		waitForElementVisible(driver, dayDropDown);
		selectItemInDefaulDropdown(dayDropDown, month);
		
		
	}

	public void selectYearDropdown(String year) {
		waitForElementVisible(driver, yearDropDown);
		selectItemInDefaulDropdown(yearDropDown, year);
		
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, emailAddress);
		
	}

	public void enterToCompanyTextbox(String comapnyName) {
		
		waitForElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, comapnyName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		registerButton.click();
		
	}

	public boolean isRegisterSuccessMesageDisplay() {
		waitForElementVisible(driver, registerSuccessMassage);
		return isElementIsDisplay(driver, registerSuccessMassage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver,logoutLink);
		logoutLink.click();
		
	}
	
	
	

}
