package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import Page_UI.nopCommerce.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		System.out.println("Driver at Home Page:"+ driver.toString());
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

}
