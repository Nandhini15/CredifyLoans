package com.loans.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.loans.constants.Constants;
import com.loans.utils.ReadPropertiesUtil;

public class BaseTest implements Constants {

	protected WebDriver driver;
	ReadPropertiesUtil properties;
	String login_url;

	@Parameters({ "browser" })
	@BeforeGroups("smoke")
	public void beforeGroupsInParent(@Optional(optional_browser_name) String browser) {
		System.out.println("Before groups in BaseTest");
		setUp(browser);
	}
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTestInParent(@Optional(optional_browser_name) String browser) {
		setUp(browser);
	}

	@AfterTest
	public void tearDownInParent() {
		driver.quit();
	}
	
	private void setUp(String browser) {
		properties = new ReadPropertiesUtil(config_file_path);
		String url = properties.getValue(browser_URL);
		login_url = properties.getValue(portal_login_URL);
		String chrome_driver_path = properties.getValue(browser_Chrome_Path);
		String gecko_driver_path = properties.getValue(browser_Gecko_Path);
		if (browser.equals(browser_chrome)) {
			System.setProperty(webdriver_chrome_driver, chrome_driver_path);
			driver = new ChromeDriver();
		} else if (browser.equals(browser_firefox)) {
			System.setProperty(webdriver_gecko_driver, gecko_driver_path);
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
}