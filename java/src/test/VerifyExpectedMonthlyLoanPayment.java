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
    private String loanAmount;
    private String interestRate;
    private String lengthOfLoan;
    private String homeValue;
    private String annualTaxes;
    private String annualInsurance;
    private String annualPmiPercentage;

    private void setup() {
        // Set the amounts to be entered for the loan information.
        loanAmount          = "200000"; // $200,000
        interestRate        = "5.0";    // 5.0 %
        lengthOfLoan        = "30";     // 30 years
        homeValue           = "235000"; // 235,000
        annualTaxes         = "2000";   // $2,000 per year
        annualInsurance     = "1865";   // $1,865 per year
        annualPmiPercentage = "0.52";   // 0.52 %
    }

    public void main (String[] args) {
        // Run test setup.
        setup();

        //
    }

}

