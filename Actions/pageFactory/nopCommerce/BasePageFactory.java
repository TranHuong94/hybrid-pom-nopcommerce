package pageFactory.nopCommerce;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



	
	public class BasePageFactory {
		private WebDriver driver;
		
		
		
		
		public void openPageUrl(WebDriver driver, String pageUrl) {
			driver.get(pageUrl);
		}

		public String getTitle(WebDriver driver) {
			return driver.getTitle();
		}

		public String getCurrentUrl(WebDriver driver) {
			return driver.getCurrentUrl();
		}

		public String getPageSourceCode(WebDriver driver) {
			return driver.getPageSource();
		}

		public void backToPage(WebDriver driver) {
			driver.navigate().back();
		}

		public void forwordToPage(WebDriver driver) {
			driver.navigate().forward();
		}

		public void refreshCurrentPage(WebDriver driver) {
			driver.navigate().refresh();
		}

		public Alert waitForAlertPresent(WebDriver driver) {
			explicitWait = new WebDriverWait(driver, longTimeOut);
			return explicitWait.until(ExpectedConditions.alertIsPresent());

		}

		public void acceptAlert(WebDriver driver) {
			// Vừa wait vừa accept sẽ ít lỗi hơn chỉ accept
			alert = waitForAlertPresent(driver);
			alert.accept();
		}

		public void cancelAlert(WebDriver driver) {

			alert = waitForAlertPresent(driver);
			alert.dismiss();
		}

		public void sendkeyToAlert(WebDriver driver, String value) {

			alert = waitForAlertPresent(driver);
			alert.sendKeys(value);

		}

		public String getTextInAlert(WebDriver driver) {

			alert = waitForAlertPresent(driver);
			return alert.getText();

		}

		//chỉ dùng trong case có 2 tab
		public void switchToWindowByID(WebDriver driver, String parentID) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindow : allWindows) {
				if (!runWindow.equals(parentID)) {
					driver.switchTo().window(runWindow);
					break;
				}
			}
		}

		// nhiều hơn hoặc bằng 2 tab đều đúng
		public void switchToWindowByTitle(WebDriver driver, String title) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindows : allWindows) {
				driver.switchTo().window(runWindows);
				String currentWin = driver.getTitle();
				if (currentWin.equals(title)) {
					break;
				}
			}
		}

		public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String runWindows : allWindows) {
				if (!runWindows.equals(parentID)) {
					driver.switchTo().window(runWindows);
					driver.close();
				}
			}
			driver.switchTo().window(parentID);
		}

		public void clickToElement(WebDriver driver, WebElement element) {
	    	waitForElementClickable(driver, element).click();
		}
		public WebElement waitForElementClickable(WebDriver driver, WebElement element) {
			explicitWait = new WebDriverWait(driver, longTimeOut);
			return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public void sendkeyToElement(WebDriver driver, WebElement element, String value) {
			element.clear();
			element.sendKeys(value);
		}
		public String getElementText (WebElement element) {
			return element.getText();
		}
		public boolean isElementIsDisplay(WebDriver driver, WebElement element) {
			return waitForElementVisible(driver, element).isDisplayed();
		}
		public WebElement waitForElementVisible(WebDriver driver, WebElement element) {
			explicitWait = new WebDriverWait(driver, longTimeOut);
			return explicitWait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public boolean isElementIsSelect( WebElement element) {
			return element.isSelected();
		}
		
		public boolean isElementIsEnable( WebElement element) {
			return element.isEnabled();
		}
		public void selectItemInDefaulDropdown( WebElement element, String itemText) {
			select = new Select(element);
			select.selectByVisibleText(itemText);	
		}
		public String getFirstSelectItemInDropdown(WebElement element) {
			select = new Select(element);
			return select.getFirstSelectedOption().getText();
		}
		public String getAttributeValue (WebElement element, String attributName) {
			return element.getAttribute(attributName);
		}
		

	private Alert alert;
	private Select select;
	private Actions action;
	private long longTimeOut = 30;
	private long shortTimeOut = 5;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	}
