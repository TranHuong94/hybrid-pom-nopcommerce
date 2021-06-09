package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_02_Register_Login_BasePage_Part2 {
	BasePage basePage;
	Select select;
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
     
	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 // truy cập trực tiếp từ tên class để gọi hàm ra mà k cần new
		 //(tính che giấu khởi tạo 1 đối tượng giống tính đóng gói)
		 basePage = BasePage.getBasePage();
		 basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
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
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//input[@id='gender-male']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		basePage.selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		basePage.selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		basePage.selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		
		
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
		

		
		//check: nếu chưa được chọn thì click
		basePage.checkToCheckboxRadio(driver, "//input[@id='Newsletter']");
		
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		
	
		
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		
		//verify 
		
		Assert.assertTrue(basePage.isElementIsDisplay(driver, "//div[@class='result']"));
		
		//logout
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
		
	}
	@Test
	public void TC_02_Login() {
		basePage.clickToElement(driver, "//a[@class='ico-login']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		
		basePage.clickToElement(driver, "//button[@class='button-1 login-button']");
		
		Assert.assertTrue(basePage.isElementIsDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(basePage.isElementIsDisplay(driver, "//a[@class='ico-logout']"));
		
		
		
		
	}
	@Test
	public void TC_03_Verify() {
		basePage.clickToElement(driver, "//a[@class='ico-account']");
		Assert.assertEquals(basePage.getElementText(driver, "//h1[text()='My account - Customer info']"), "My account - Customer info");
   
		Assert.assertTrue(basePage.isElementIsSelect(driver, "//input[@id='gender-male']"));
		
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		
		
		
		//getFirstSelectedOption vì cái được chọn sẽ được đưa lên đầu
		Assert.assertEquals(basePage.getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(basePage.getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(basePage.getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
		
		
		
		
		
		
		
		
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
