import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A simple test of the https://www.mortgageloan.com/calculator page which verifies expected 'Total Monthly Payments'.
 */
public class VerifyExpectedMonthlyLoanPayment {

    // Input values.
    private String annualInsurance;
    private String annualPmiPercentage;
    private String annualTaxes;
    private String homeValue;
    private String interestRate;
    private String lengthOfLoan;
    private String loanAmount;

    // Expected result values.
    private String expectedLoanToValueRatio;
    private String expectedMonthlyPrinciple;
    private String expectedTotalMonthlyPayment;
    
    // The page object representing the mortgage calculator.
    private MortgageCalculatorPage calculatorPage;

    /**
     * Setup the test by initializing input and expected data, and the page object.
     */
    private void setup() {
        // Set the amounts to be entered for the loan information.
        loanAmount          = "200000"; // $200,000
        homeValue           = "235000"; // 235,000
        annualTaxes         = "2000";   // $2,000 per year
        lengthOfLoan        = "30";     // 30 years
        interestRate        = "5.0";    // 5.0 %
        annualInsurance     = "1865";   // $1,865 per year
        annualPmiPercentage = "0.52";   // 0.52 %
        
        // Initialize the expected resulting values.
        expectedMonthlyPrinciple    = "$1,073.64";
        expectedLoanToValueRatio    = "85.11%";
        expectedTotalMonthlyPayment = "$1,482.39";

        // Initialize the mortgage calculator page object.
        calculatorPage = new MortgageCalculatorPage();
    }

    @Test
    public void testMortgageCalculator() {
        // Run test setup and wait for the calculator to appear.
        setup();

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
        calculatorPage.waitForCalculatorToLoad();
        assertTrue("Expected the results to appear.", calculatorPage.atResultsPage());
        
        // Verify that the "Monthly Principle and Interests" are as expected.
        assertEquals("Resulting Monthly Principal & Interests value is not as expected.",
                     expectedMonthlyPrinciple,
                     calculatorPage.getMonthlyPrincipleAndInterestsResult()
        );
        
        // Verify that the "Loan To Value Ratio" is as expected.
        assertEquals("Resulting Loan To Value Ratio is not as expected.",
                expectedLoanToValueRatio,
                calculatorPage.getLoanToValueRatioResult()
        );
        
        // Verify that the "Total Monthly Payments" are as expected.
        assertEquals("Resulting Total Monthly Payments value is not as expected.",
                expectedTotalMonthlyPayment,
                calculatorPage.getMonthlyPaymentResult()
        );

        // End the test by closing the web driver.
        calculatorPage.quitDriver();
    }

}

