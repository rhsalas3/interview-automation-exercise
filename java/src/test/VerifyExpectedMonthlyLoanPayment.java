import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VerifyExpectedMonthlyLoanPayment {

    // Input values
    private String loanAmount;
    private String interestRate;
    private String lengthOfLoan;
    private String homeValue;
    private String annualTaxes;
    private String annualInsurance;
    private String annualPmiPercentage;

    // Expected result values.
    private String monthlyPrinciple;
    private String monthlyRealEstateTax;
    private String monthlyInsurance;
    private String loanToValueRatio;
    private String monthsWithPmi;
    private String monthlyPmiPayment;
    private String totalyMonthlyPayment;
    
    // The page object representing the mortgage calculator.
    private MortgageCalculatorPage calculatorPage;

    private void setup() {
        // Set the amounts to be entered for the loan information.
        loanAmount          = "200000"; // $200,000
        interestRate        = "5.0";    // 5.0 %
        lengthOfLoan        = "30";     // 30 years
        homeValue           = "235000"; // 235,000
        annualTaxes         = "2000";   // $2,000 per year
        annualInsurance     = "1865";   // $1,865 per year
        annualPmiPercentage = "0.52";   // 0.52 %
        
        // Initialize the expected resulting values.
        monthlyPrinciple     = "$1,342.05";
        monthlyRealEstateTax = "$250.00";
        monthlyInsurance     = "$125.00";
        loanToValueRatio     = "83.33%";
        monthsWithPmi        = "31";
        monthlyPmiPayment    = "$104.17";
        totalyMonthlyPayment = "$1,821.22";
        
        // Initialize the mortgage calculator page object.
        calculatorPage = new MortgageCalculatorPage();
    }

    @Test
    public void testMortgageCalculator() {
        // Run test setup and wait for the calculator to appear.
        setup();
        calculatorPage.waitForCalculatorToLoad();

        // Enter in the "Loan Information" and the "Home Value".
        assertTrue("Expected to be at the 'Loan Information' step.", calculatorPage.atLoansInformationInputPage());
        calculatorPage.setLoanAmount(loanAmount);
        calculatorPage.setInterestRate(interestRate);
        calculatorPage.setLengthOfLoan(lengthOfLoan);
        calculatorPage.setHomeValue(homeValue);
        
        // Click the 'Next' button and verify that we are at the next step in the process.
        calculatorPage.clickNextButton();
        assertTrue("Expected to be at the 'Taxes & Information' step.", calculatorPage.atTaxesAndInsuranceInputPage());
        
        // Enter in the "Taxes and Insurance" information.
        calculatorPage.setAnnualInsurance(annualInsurance);
        calculatorPage.setAnnualTaxes(annualTaxes);
        calculatorPage.setAnnualPmi(annualPmiPercentage);

        // Click the 'Show Results' button and verify that the results are showing.
        calculatorPage.clickShowResultsButton();
        assertTrue("Expected the results to appear.", calculatorPage.atResultsPage());
        
        // Verify that the "Monthly Principle and Interests" are as expected.
        
        // Verify that the "Loan To Value Ratio" is as expected.
        
        // Verify that the "Total Monthly Payments" are as expected.

        // End the test by closing the web driver.
        calculatorPage.quitDriver();
    }

}

