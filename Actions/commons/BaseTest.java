package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName, String url) {

		Browser browser = Browser.valueOf(browserName.toUpperCase());

		/*
		 * if (browser == Browser.FIREFOX) {
		 * System.setProperty("webdriver.gecko.driver", projectLocation +
		 * ".\\browserDrivers\\geckodriver.exe"); driver = new FirefoxDriver(); } else
		 * if (browser == Browser.CHROME) {
		 * System.setProperty("webdriver.chrome.driver", projectLocation +
		 * ".\\browserDrivers\\chromedriver.exe"); driver = new ChromeDriver(); } else
		 * if (browser == Browser.EDGE) { System.setProperty("webdriver.edge.driver",
		 * projectLocation + ".\\browserDrivers\\msedgedriver.exe"); driver = new
		 * EdgeDriver(); } else { throw new
		 * RuntimeException("Browser name is not correct"); }
		 */
        //switch case chức năng giống với if else nhưng viết gọn hơn
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", projectLocation + ".\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case CHROME:
			//sử dụng thư viện không phải download thủ công
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", projectLocation + ".\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", projectLocation + ".\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case COCCOC:
			WebDriverManager.chromedriver().driverVersion("89.0.4389.23").setup();
			//System.setProperty("webdriver.chrome.driver", projectLocation + ".\\browserDrivers\\chromedriver89.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Huong\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
			break;

		default:
			throw new RuntimeException("Browser name is not correct");
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Driver at BaseTest:" + driver.toString());
		// return ra để gán sang class khác
		return driver;

	}

	// protected để muốn sử dụng thì phải kế thừa
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
