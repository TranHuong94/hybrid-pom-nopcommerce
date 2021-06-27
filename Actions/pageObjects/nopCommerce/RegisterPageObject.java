package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import Page_UI.nopCommerce.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage  {

	private WebDriver driver;

	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}
	
	
	
	public void clikToGenderMaleRadio() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXBOX, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXBOX, lastName);
		
		
	}

	public void selectDayDropdown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaulDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
		
	}

	public void selectMonthDropdown(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaulDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
		
		
	}

	public void selectYearDropdown(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaulDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
		
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterToCompanyTextbox(String comapnyName) {
		
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, comapnyName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public boolean isRegisterSuccessMesageDisplay() {
		waitForElementVisible(driver, RegisterPageUI.REGISTERED__SUCCESS_MESSAGE);
		return isElementIsDisplay(driver, RegisterPageUI.REGISTERED__SUCCESS_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		
	}

}

