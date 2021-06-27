package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import Page_UI.nopCommerce.MyAccountPageUI;
import commons.BasePage;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;

	public MyAccountPageObject(WebDriver _driver) {
		driver = _driver;
	}
	
	
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver, MyAccountPageUI.GENDER_MALE_RADIO);
		return isElementIsSelect(driver, MyAccountPageUI.GENDER_MALE_RADIO);
		
	}

	public String getFirstNameTexboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTexboxValue() {
		
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX, "value");
		
	}

	public String getEmailTexboxValue() {
		
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
		
	}

	public String getCompanyNameTexboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");
		
	}

	public String getDayDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		return getFirstSelectItemInDropdown(driver, MyAccountPageUI.DAY_DROPDOWN);
	  
	}

	public String getMonthDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getFirstSelectItemInDropdown(driver, MyAccountPageUI.MONTH_DROPDOWN);
		
	}	

	public String getYearDropdownValue() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getFirstSelectItemInDropdown(driver, MyAccountPageUI.YEAR_DROPDOWN);
		
	}

}
