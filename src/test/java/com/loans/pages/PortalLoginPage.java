package com.loans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PortalLoginPage {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "username")
	WebElement loginUsernameElement;

	@FindBy(how = How.NAME, using = "password")
	WebElement loginPasswordElement;

	@FindBy(how = How.XPATH, using = "//button[@data-auto='login']")
	WebElement loginSubmitElement;

	public PortalLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setLoginUsername(String userName) {
		loginUsernameElement.clear();
		loginUsernameElement.sendKeys(userName);
	}

	public void setLoginPassword(String password) {
		loginPasswordElement.clear();
		loginPasswordElement.sendKeys(password);
	}

	public void clickOnLoginSubmit() {
		loginSubmitElement.click();
	}

	public void portalLogin(String uname, String pass) {
		setLoginUsername(uname);
		setLoginPassword(pass);
		clickOnLoginSubmit();
	}

}
