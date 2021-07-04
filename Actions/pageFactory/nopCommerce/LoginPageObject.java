package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_UI.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePageFactory{
	 WebDriver driver;
	 public LoginPageObject(WebDriver _driver) {
			driver = _driver;
			
			//khởi tạo(init) element
			PageFactory.initElements(driver, this);//this là tên class, dòng này để find element
		}
	 @FindBy(how=How.XPATH, using = "//input[@id='Email']") 
	 WebElement emailTexbox;
	 @FindBy(how=How.XPATH, using = "//input[@id='Password']") 
	 WebElement passwordTexbox;
	@FindBy(how=How.XPATH, using = "//button[@class='button-1 login-button']") 
	WebElement loginButton;
	
	
	public void enterToEmailTexbox(String emailAddress) {
		waitForElementVisible(driver, emailTexbox);
		sendkeyToElement(driver, emailTexbox, emailAddress);

	}

	public void enterToPasswordTexbox(String password) {
		waitForElementVisible(driver, passwordTexbox);
		sendkeyToElement(driver, passwordTexbox, password);

	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
