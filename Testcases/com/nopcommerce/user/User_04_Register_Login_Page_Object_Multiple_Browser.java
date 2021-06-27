package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class User_04_Register_Login_Page_Object_Multiple_Browser extends BaseTest {
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	RegisterPageObject registerPage;

	WebDriver driver;

	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);
		System.out.println("Driver at Test Class :" + driver.toString());

		// System.setProperty("webdriver.edge.driver", projectLocation +
		// ".\\BrowserDrivers\\msedgedriver.exe");
		// driver = new EdgeDriver();

		// mở app URL lên --> navigate đến home page

		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "automationfc" + getRandomNumber() + "@mailinator.com";
		companyName = "Automation FC";
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.clikToGenderMaleRadio();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(day);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyTextbox(companyName);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMesageDisplay());

		// 3 - từ register click vào logout link --> navigate home
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void TC_02_Login() {
		// 4- đang từ home page --> navigate login page
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTexbox(emailAddress);
		loginPage.enterToPasswordTexbox(password);
		loginPage.clickToLoginButton();

		// 5 - đang từ login page click --> navigate home page
		homePage = new HomePageObject(driver);

	}

	@Test
	public void TC_03_Verify() {
		homePage.clickToMyAccountLink();
		// 6- đang từ home page click --> navigate myaccount page
		myAccountPage = new MyAccountPageObject(driver);

		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		Assert.assertEquals(myAccountPage.getFirstNameTexboxValue(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameTexboxValue(), lastName);
		Assert.assertEquals(myAccountPage.getEmailTexboxValue(), emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTexboxValue(), companyName);

		Assert.assertEquals(myAccountPage.getDayDropdownValue(), day);
		Assert.assertEquals(myAccountPage.getMonthDropdownValue(), month);
		Assert.assertEquals(myAccountPage.getYearDropdownValue(), year);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
