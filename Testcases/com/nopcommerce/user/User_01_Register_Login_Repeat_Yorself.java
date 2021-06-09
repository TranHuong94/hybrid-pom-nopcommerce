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

public class User_01_Register_Login_Repeat_Yorself {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
     
	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 driver.get("https://demo.nopcommerce.com/");
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
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText(day);
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(month);
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(year);
		
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		
		//check: nếu chưa được chọn thì click
		if (!driver.findElement(By.id("Newsletter")).isSelected()) {
			driver.findElement(By.id("Newsletter")).click();
		}
		
		driver.findElement(By.id("Password")).sendKeys( password );
		driver.findElement(By.id("ConfirmPassword")).sendKeys( password );
		
		
		driver.findElement(By.id("register-button")).click();
		
		//verify 
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']")).isDisplayed());
		//logout
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}
	@Test
	public void TC_02_Login() {
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys( password );
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed());
		
		
		
	}
	@Test
	public void TC_03_Verify() {
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='My account - Customer info']")).getText(), "My account - Customer info");
		
		Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected());
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		//getFirstSelectedOption vì cái được chọn sẽ được đưa lên đầu
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		
		
		
		
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
