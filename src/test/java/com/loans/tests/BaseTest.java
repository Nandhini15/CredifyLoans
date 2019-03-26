package com.loans.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public static final String USERNAME = "mary384";
	public static final String AUTOMATE_KEY = "15uhzuF3Y5zaezsyFwuJ";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

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
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.WINDOWS);
		capability.setBrowserName("chrome");
		capability.setVersion("73");
		capability.setCapability("browserstack.debug", "true");
		URL browserStackUrl = null;
		try {
			browserStackUrl = new URL(URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(browserStackUrl, capability);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
}