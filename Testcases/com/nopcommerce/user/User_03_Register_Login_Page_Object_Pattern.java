package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class User_03_Register_Login_Page_Object_Pattern  {
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	RegisterPageObject registerPage;
	
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
     
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", projectLocation +  ".\\browserDrivers\\chromedriver.exe");
  		 driver = new ChromeDriver();
		 //System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 //driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 
		//mở app URL lên --> navigate đến home page
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		 
		firstName = "Automation";
		 lastName = "FC";
		 day = "10";
		 month = "May";
		 year = "1999";
		 emailAddress = "automationfc" + getRandomNumber() + "@mailinator.com" ;
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
public int getRandomNumber() {
	Random rand = new Random();
	return rand.nextInt(9999);
}
}
