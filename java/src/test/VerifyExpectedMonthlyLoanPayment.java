import java.src.main.MortgageCalculatorPage;

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

    public void main (String[] args) {
        // Run test setup.
        setup();

        // Enter in the "Loan Information" and the "Home Value".
        
        // Click the 'Next' button and verify that we are at the next step in the process.
        
        // Enter in the "Taxes and Insurance" information.
        
        // Click the 'Show Results' button and verify that the results are showing.
        
        // Verify that the "Monthly Principle and Interests" are as expected.
        
        // Verify that the "Loan To Value Ratio" is as expected.
        
        // Verify that the "Total Monthly Payments" are as expected.
    }

}

