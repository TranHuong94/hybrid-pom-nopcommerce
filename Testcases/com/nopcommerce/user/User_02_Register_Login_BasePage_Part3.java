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

public class User_02_Register_Login_BasePage_Part3 extends BasePage {
	BasePage basePage;
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
     
	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 // truy cập trực tiếp từ tên class để gọi hàm ra mà k cần lưu
		 //tính che giấu khởi tạo 1 đối tượng giống tính đóng gói
		 
		openPageUrl(driver, "https://demo.nopcommerce.com/");
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
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		selectItemInDefaulDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		
		
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Company']", companyName);
		

		
		//check: nếu chưa được chọn thì click
		checkToCheckboxRadio(driver, "//input[@id='Newsletter']");
		
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		
	
		
		clickToElement(driver, "//button[@id='register-button']");
		
		
		//verify 
		
		Assert.assertTrue(isElementIsDisplay(driver, "//div[@class='result']"));
		
		//logout
		clickToElement(driver, "//a[@class='ico-logout']");
		
	}
	@Test
	public void TC_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		
		clickToElement(driver, "//button[@class='button-1 login-button']");
		
		Assert.assertTrue(isElementIsDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementIsDisplay(driver, "//a[@class='ico-logout']"));
	
	}
	@Test
	public void TC_03_Verify() {
		clickToElement(driver, "//a[@class='ico-account']");
		Assert.assertEquals(getElementText(driver, "//h1[text()='My account - Customer info']"), "My account - Customer info");
   
		Assert.assertTrue(isElementIsSelect(driver, "//input[@id='gender-male']"));
		
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		
		
		
		//getFirstSelectedOption vì cái được chọn sẽ được đưa lên đầu
		Assert.assertEquals(getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(getFirstSelectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
		
		
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
