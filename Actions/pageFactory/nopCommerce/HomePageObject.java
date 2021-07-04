package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePageFactory{
	
 WebDriver driver;
 WebDriverWait explicitWait;
 
	
	public HomePageObject(WebDriver _driver) {
		
		driver = _driver;
		explicitWait = new WebDriverWait(driver, 30);
		//khởi tạo(init) element
		PageFactory.initElements(driver, this);//this là tên class, dòng này để find element
	}
	
	//page UI locator
	@FindBy(how=How.XPATH, using ="/a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(how=How.XPATH, using= "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(how=How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	//page Object action
	 public void clickToRegisterLink() {
		 waitForElementClickable(driver, registerLink);
		 registerLink.click();
	 }
	 public void clickToLoginLink() {
		 waitForElementClickable(driver, loginLink);
		 loginLink.click();
	 }
	 public void clickToMyAccountLink() {
		 waitForElementClickable(driver, myAccountLink);
		 myAccountLink.click();
	 }

}
