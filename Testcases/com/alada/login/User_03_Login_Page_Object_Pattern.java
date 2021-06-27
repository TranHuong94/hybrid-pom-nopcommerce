package com.alada.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.alada.HomePageObject;
import pageObjects.alada.LoginPageObject;


public class User_03_Login_Page_Object_Pattern  {
	
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	
	String projectLocation = System.getProperty("user.dir");
	
     
	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 
		//mở app URL lên --> navigate đến login page
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		loginPage = new LoginPageObject(driver);
		
		 
		
		
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickRegisterButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Vui lòng nhập email");
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextbox(),"Vui lòng nhập mật khẩu");
		
	
	}
		
	@Test
	public void TC_02_Login_With_Invalid_Emali() {
		loginPage.enterToEmailTextbox("automation@");
		loginPage.enterToPasswordTextbox("12345");
		loginPage.clickRegisterButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Vui lòng nhập email hợp lệ");
		
		
		
		
		
		
		
	}
	@Test
	public void TC_03_Login_With_Email_Not_Register() {
		loginPage.enterToEmailTextbox("automation" + getRandomNumber() + "@hotmail.com");
		loginPage.enterToPasswordTextbox("12345");
		loginPage.clickRegisterButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Email này chưa được đăng ký.");
		
	}
	
	public void TC_04_Login_With_Invalid_Password() {
		//invaild password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickRegisterButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Mật khẩu sai.");
		
		//incorrect password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("1111111");
		loginPage.clickRegisterButton();
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Mật khẩu sai.");
		
	}
	
	public void TC_05_Login_With_Valid_Data() {
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickRegisterButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyCourseDisplay());
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
