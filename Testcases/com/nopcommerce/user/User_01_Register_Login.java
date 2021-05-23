package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectLocation +  ".\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.edge.driver", projectLocation +  ".\\BrowserDrivers\\msedgedriver.exe");
		 //driver = new EdgeDriver();
		 driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Empty_data() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
