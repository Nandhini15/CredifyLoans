package com.loans.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.loans.pages.LoanLandingPage;
import com.loans.pages.LoanOffersPage;
import com.loans.pages.PersonalInfoForLoanPage;
import com.loans.pages.PortalLoginPage;
import com.loans.pages.PortalOffersPage;

public class LoanVerificationTest extends BaseTest {

	LoanLandingPage landingPage;
	PersonalInfoForLoanPage personalInfoPage;
	LoanOffersPage loanOffersPage;
	PortalLoginPage portalLoginPage;
	PortalOffersPage portalOffersPage;

	@BeforeMethod(groups = "smoke") 
	public void beforeMethodInLoanLandingPageTest() {
		System.out.println("Hello Before Method.");
		landingPage = PageFactory.initElements(driver, LoanLandingPage.class);
		System.out.println("");
		
	}

	@Test(groups= {"smoke", "regression"})
	public void submitLoanRequestForm() {
		System.out.println("Hello Nandu");
		landingPage.fillTheLoanFormAndSubmit(properties.getValue(loan_Amount), properties.getValue(purpose_Of_Loan));
		System.out.println("Hello Nandu2");
		personalInfoPage = PageFactory.initElements(driver, PersonalInfoForLoanPage.class);
		
		// Fill user details and submit
		personalInfoPage.fillThePersonalInformationForValidation(properties.getValue(borrower_FirstName),
							properties.getValue(borrower_LastName),
							properties.getValue(borrower_Street),
							properties.getValue(borrower_City),
							properties.getValue(borrower_State),
							properties.getValue(borrower_ZIP),
							properties.getValue(borrower_DOB),
							properties.getValue(borrower_Income),
							properties.getValue(borrower_AddIncome),
							properties.getValue(username),
							properties.getValue(password));
				
		loanOffersPage = PageFactory.initElements(driver, LoanOffersPage.class);
		String fasterPayOffMonthlyPayment = loanOffersPage.getFasterPayOffMonthlyPayment();
		String loanAPR = loanOffersPage.getLoanAPR();
		String loanTerm = loanOffersPage.getLoanTerm();
		String userLoanAmount = loanOffersPage.getUserLoanAmount();
		
		loanOffersPage.signOutOperation();
		
		driver.navigate().to(login_url);
		portalLoginPage = PageFactory.initElements(driver, PortalLoginPage.class);
		
		portalLoginPage.portalLogin(properties.getValue(username), properties.getValue(password));
		
		portalOffersPage = PageFactory.initElements(driver, PortalOffersPage.class);
		String fasterPayOffMonthlyPayment2 = portalOffersPage.getFasterPayOffMonthlyPayment();
		String loanAPR2 = portalOffersPage.getLoanAPR();
		String loanTerm2 = portalOffersPage.getLoanTerm();
		String userLoanAmount2 = portalOffersPage.getUserLoanAmount();
		portalOffersPage.signOutInPortal();
		Assert.assertEquals(fasterPayOffMonthlyPayment, fasterPayOffMonthlyPayment2);
		Assert.assertEquals(loanAPR, loanAPR2);
		Assert.assertEquals(loanTerm, loanTerm2);
		Assert.assertEquals(userLoanAmount, userLoanAmount2);
	}
	
	@Test(groups= {"regression"})
	void testCase2() {
		
	}
	
	@Test(groups= {"smoke"})
	void testCase3() {
		System.out.println("Hello TestCase 3");
		
	}

}
