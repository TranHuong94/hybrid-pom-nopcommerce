package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import PageUI.alada.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyCourseDisplay() {
		waitForElementVisible(driver, HomePageUI.MY_COURSE_LINK);
		return isElementIsDisplay(driver, HomePageUI.MY_COURSE_LINK);
	}
	

}
