package pageObjects.alada;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageUI.alada.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
		
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, LoginPageUI.REGISTER_BUTTON);
		clickToElement(driver, LoginPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
	
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		
		
	}

	public String getErrorMessageAtLoginForm() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_FORM_ERROR_MESSAGE);
		
		
	}

}
