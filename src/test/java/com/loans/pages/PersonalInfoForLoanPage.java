package com.loans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalInfoForLoanPage {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "borrowerFirstName")
	WebElement borrowerFirstNameElement;

	@FindBy(how = How.NAME, using = "borrowerLastName")
	WebElement borrowerLastNameElement;

	@FindBy(how = How.NAME, using = "borrowerStreet")
	WebElement borrowerStreetElement;

	@FindBy(how = How.NAME, using = "borrowerCity")
	WebElement borrowerCityElement;

	@FindBy(how = How.NAME, using = "borrowerState")
	WebElement borrowerStateElement;

	@FindBy(how = How.NAME, using = "borrowerZipCode")
	WebElement borrowerZipCodeElement;

	@FindBy(how = How.NAME, using = "borrowerDateOfBirth")
	WebElement borrowerDateOfBirthElement;

	@FindBy(how = How.NAME, using = "borrowerIncome")
	WebElement borrowerIncomeElement;

	@FindBy(how = How.NAME, using = "borrowerAdditionalIncome")
	WebElement borrowerAdditionalIncomeElement;

	@FindBy(how = How.NAME, using = "username")
	WebElement usernameElement;

	@FindBy(how = How.NAME, using = "password")
	WebElement passwordElement;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']/following-sibling::div[1]")
	WebElement agreementsElement;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement agreementSubmitElement;

	public PersonalInfoForLoanPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setBorrowerFirstName(String firstName) {
		borrowerFirstNameElement.clear();
		borrowerFirstNameElement.sendKeys(firstName);
	}

	public void setBorrowerLastName(String lastName) {
		borrowerLastNameElement.clear();
		borrowerLastNameElement.sendKeys(lastName);
	}

	public void setBorrowerStreet(String street) {
		borrowerStateElement.clear();
		borrowerStreetElement.sendKeys(street);
	}

	public void setBorrowerCity(String city) {
		borrowerCityElement.clear();
		borrowerCityElement.sendKeys(city);
	}

	public void setBorrowerState(String state) {
		borrowerStateElement.clear();
		borrowerStateElement.sendKeys(state);
	}

	public void setBorrowerZipCode(String zipCode) {
		borrowerZipCodeElement.clear();
		borrowerZipCodeElement.sendKeys(zipCode);
	}

	public void setBorrowerDateOfBirth(String dateOfBirth) {
		borrowerDateOfBirthElement.clear();
		borrowerDateOfBirthElement.sendKeys(dateOfBirth);
	}

	public void setBorrowerIncome(String income) {
		borrowerIncomeElement.clear();
		borrowerIncomeElement.sendKeys(income);
	}

	public void setBorrowerAdditionalIncome(String additionalIncome) {
		borrowerAdditionalIncomeElement.clear();
		borrowerAdditionalIncomeElement.sendKeys(additionalIncome);
	}

	public void setBorrowerUsername(String userName) {
		usernameElement.clear();
		usernameElement.sendKeys(userName);
	}

	public void setBorrowerPassword(String password) {
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void clickOnAgreements() {
		agreementsElement.click();
	}

	public void clickOnAgreementsSubmit() {
		agreementSubmitElement.click();
	}

	public void fillThePersonalInformationForValidation(String firstName, String lastName, String street, String city,
			String state, String zipCode, String dateOfBirth, String income, String additionalIncome, String userName,
			String password) {
		setBorrowerFirstName(firstName);
		setBorrowerLastName(lastName);
		setBorrowerStreet(street);
		setBorrowerCity(city);
		setBorrowerState(state);
		setBorrowerZipCode(zipCode);
		setBorrowerDateOfBirth(dateOfBirth);
		setBorrowerIncome(income);
		setBorrowerAdditionalIncome(additionalIncome);
		setBorrowerUsername(userName);
		setBorrowerPassword(password);
		clickOnAgreements();
		clickOnAgreementsSubmit();
	}
}
