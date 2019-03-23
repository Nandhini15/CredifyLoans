package com.loans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PortalOffersPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[@data-auto='userLoanAmount']")
	WebElement userLoanAmountElement;

	@FindBy(how = How.XPATH, using = "(//span[@data-auto='defaultMonthlyPayment'])[1]")
	WebElement fasterPayOffMonthlyPaymentElement;

	@FindBy(how = How.XPATH, using = "(//div[@data-auto='defaultLoanTerm'])[1]")
	WebElement loanTermElement;

	@FindBy(how = How.XPATH, using = "(//div[@data-auto='defaultMoreInfoAPR']/div)[1]")
	WebElement loanAPRElement;

	@FindBy(how = How.XPATH, using = "//div[@class='header-nav']")
	WebElement menuElement;

	@FindBy(how = How.XPATH, using = "(//a[@class='header-nav-menu__link'])[2]")
	WebElement signOutElement;

	public PortalOffersPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserLoanAmount() {
		String userLoanAmount = userLoanAmountElement.getText();
		return userLoanAmount;
	}

	public String getFasterPayOffMonthlyPayment() {
		String monthlyPay = fasterPayOffMonthlyPaymentElement.getText();
		return monthlyPay;
	}

	public String getLoanTerm() {
		String loanTerm = loanTermElement.getText();
		return loanTerm;
	}

	public String getLoanAPR() {
		String loanAPR = loanAPRElement.getText();
		return loanAPR;
	}

	public void clickOnMenu() {
		// WebDriverWait wait = new WebDriverWait(driver, 2000);
		// wait.until(ExpectedConditions.elementToBeClickable(menuElement));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		menuElement.click();
	}

	public void clickOnSignOut() {
		signOutElement.click();
	}

	public void signOutInPortal() {
		clickOnMenu();
		clickOnSignOut();
	}

}
