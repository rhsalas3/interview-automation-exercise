public class MortgageCalculatorInputPage {

        /*
         *
         */
        public boolean atTaxesAndInsuranceInputPage() {
            return nextButton().isDisplayed();
        }

        // TODO: Could be useful to use the page's url... driver.getURL() ??

        /*
         *
         */
        public boolean atLoansInformationInputPage() {
            return nextButton().isDisplayed();
        }

        //////////////////////////////////////////////////////////
        // Elements of the page.
        //////////////////////////////////////////////////////////

        private WebElement nextButton() {
            return driver.findElement(By.cssSelector("#calculator-form > div > ul > li.next > a.next-button"));
        }

        private WebElement showResultsButton() {
            return driver.findElement(By.cssSelector("#calculator-form > div > ul > li.finish > a.finish-button"));
        }

        private WebElement loanAmountInput() {
            return driver.findElement(By.id("calculator_widget_amount"));
        }

        private WebElement lengthOfLoanInput() {
            return driver.findElement(By.id("calculator_widget_Length"));
        }

        private WebElement interestRateInput() {
            return driver.findElement(By.id("calculator_widget_interest"));
        }

        private WebElement homeValueInput() {
            return driver.findElement(By.id("calculator_widget_HomeValue"));
        }

        private WebElement annualTaxesInput() {
            return driver.findElement(By.id("calculator_widget_PropertyTaxes"));
        }

        private WebElement annualInsuranceInput() {
            return driver.findElement(By.id("calculator_widget_Insurance"));
        }

        private WebElement annualPmiInput() {
            return driver.findElement(By.id("calculator_widget_PMI"));
        }

        //////////////////////////////////////////////////////////
        // Helper methods.
        //////////////////////////////////////////////////////////

        /*
         * Enter the 'Loan Amount' value.
         *
         * @param loanAmount String - the amount requested for the loan, as whole dollars.
         */
        public void setLoanAmount(final String loanAmount) {
            loanAmountInput().enter(loanAmount);
        }

        /*
         * Enter the 'Interest Rate' percentage.
         *
         * @param rate String - the interest rate as a percentage.
         */
        public void setInterestRate(final String rate) {
            interestRateInput().enter(rate);
        }

        /*
         * Enter the length of time the loan is for.
         *
         * @param length String - the length of time in years.
         */
        public void setLengthOfLoan(final String length) {
            lengthOfLoanInput().enter(length);
        }

        /*
         * Enter the value of the home to be mortgaged.
         *
         * @param homeValue String - the value of the home.
         */
        public void setHomeValue(final String homeValue) {
            homeValueInput().enter(homeValue);
        }

        /*
         * Enter the 'Annual Taxes' value as a dollar amount.
         *
         * @param taxesAsAmount String - the whole dollar amount of annual taxes paid.
         */
        public void setAnnualTaxes(final String taxesAsAmount) {
            annualTaxesInput().enter(taxesAsAmount);
        }

        /*
         * Enter the 'Annual Insurance' value as a dollar amount.
         *
         * @param insurancePaid String - the whole dollar amount of annual insurance paid.
         */
        public void setAnnualInsurance(final String insurancePaid) {
            annualInsuranceInput().enter(insurancePaid);
        }

        /*
         * Enter the 'Annual PMI' value as a percentage.
         *
         * @param pmiAmount String - the annual PMI percentage.
         */
        public void setAnnualPmi(final String pmiAmount) {
            annualPmiInput().enter(pmiAmount);
        }

        /*
         * Click the 'Next' button.
         */
        public void clickNextButton() {
            nextButton().click();
        }

        /*
         * Click the 'Show Results' button.
         */
        public void clickShowResultsButton() {
            showResultsButton().click();
        }

}
