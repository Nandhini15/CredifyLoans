package com.loans.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoanLandingPage {

	WebDriver driver;

	@FindBy(id = "loan-amount")
	WebElement enterLoanAmountElement;

	@FindBy(how = How.ID, using = "loan-purpose-select")
	WebElement enterLoanPurposeSelectElement;

	@FindBy(how = How.XPATH, using = "//select[@id='loan-purpose-select']/option")
	List<WebElement> chooseLoanPurposeSelectElement;

	@FindBy(how = How.ID, using = "loan-form-submit")
	WebElement loanFormSubmitElement;

	public LoanLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setLoanAmount(String loanAmount) {
		enterLoanAmountElement.clear();
		enterLoanAmountElement.sendKeys(loanAmount);
	}

	public void clickOnPurposeOfLoan() {
		enterLoanPurposeSelectElement.click();
	}

	public void choosePurposeOfLoan(String purposeOfLoan) {
		for (WebElement element : chooseLoanPurposeSelectElement) {
			if (element.getText().equals(purposeOfLoan)) {
				element.click();
			}
		}
	}

	public void clickOnLoanFormSubmit() {
		loanFormSubmitElement.click();
	}

	public void fillTheLoanFormAndSubmit(String loanAmount, String purposeOfLoan) {
		setLoanAmount(loanAmount);
		clickOnPurposeOfLoan();
		choosePurposeOfLoan(purposeOfLoan);
		clickOnLoanFormSubmit();
		System.out.println("loan init form");
	}

}
