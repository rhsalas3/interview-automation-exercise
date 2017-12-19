import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class representing the https://www.mortgageloan.com/calculator page.
 */
public class MortgageCalculatorPage {

    private static WebDriver chromeDriver = new ChromeDriver();

    /**
     * Default constructor.
     */
    public MortgageCalculatorPage() {
        chromeDriver.get("https://www.mortgageloan.com/calculator");
    }

    public void quitDriver() {
        chromeDriver.quit();
    }

    /**
     * Determine whether or not the calculator is at the "Loan Information" step.
     */
    public boolean atLoansInformationInputPage() {
        return nextButton().isDisplayed();
    }

    /**
     * Determine whether or not the calculator is at the "Taxes and Insurance Information" step.
     */
    public boolean atTaxesAndInsuranceInputPage() {
        return showResultsButton().isDisplayed();
    }

    /**
     * Determine whether or not the calculator is displaying the results.
     */
    public boolean atResultsPage() {
        return nextButton().isDisplayed();
    }

    //////////////////////////////////////////////////////////
    // Elements of the page.
    //////////////////////////////////////////////////////////

    private WebElement nextButton() {
        return chromeDriver.findElement(By.cssSelector("#calculator-form > div > ul > li.next > a.next-button"));
    }

    private WebElement showResultsButton() {
        return chromeDriver.findElement(By.cssSelector("#calculator-form > div > ul > li.finish > a.finish-button"));
    }

    private WebElement loanAmountInput() {
        return chromeDriver.findElement(By.id("calculator_widget_amount"));
    }

    private WebElement lengthOfLoanInput() {
        return chromeDriver.findElement(By.id("calculator_widget_Length"));
    }

    private WebElement interestRateInput() {
        return chromeDriver.findElement(By.id("calculator_widget_interest"));
    }

    private WebElement homeValueInput() {
        return chromeDriver.findElement(By.id("calculator_widget_HomeValue"));
    }

    private WebElement annualTaxesInput() {
        return chromeDriver.findElement(By.id("calculator_widget_PropertyTaxes"));
    }

    private WebElement annualInsuranceInput() {
        return chromeDriver.findElement(By.id("calculator_widget_Insurance"));
    }

    private WebElement annualPmiInput() {
        return chromeDriver.findElement(By.id("calculator_widget_PMI"));
    }

    private WebElement monthlyPaymentResultLabel() {
        return chromeDriver.findElement(By.cssSelector("#calculator_result > div.cta-amount"));
    }

    //////////////////////////////////////////////////////////
    // Helper methods.
    //////////////////////////////////////////////////////////

    /**
     * Enter the 'Loan Amount' value.
     *
     * @param loanAmount String - the amount requested for the loan, as whole dollars.
     */
    public void setLoanAmount(final String loanAmount) {
        loanAmountInput().sendKeys(loanAmount);
    }

    /**
     * Enter the 'Interest Rate' percentage.
     *
     * @param rate String - the interest rate as a percentage.
     */
    public void setInterestRate(final String rate) {
        interestRateInput().sendKeys(rate);
    }

    /**
     * Enter the length of time the loan is for.
     *
     * @param length String - the length of time in years.
     */
    public void setLengthOfLoan(final String length) {
        lengthOfLoanInput().sendKeys(length);
    }

    /**
     * Enter the value of the home to be mortgaged.
     *
     * @param homeValue String - the value of the home.
     */
    public void setHomeValue(final String homeValue) {
        homeValueInput().sendKeys(homeValue);
    }

    /**
     * Enter the 'Annual Taxes' value as a dollar amount.
     *
     * @param taxesAsAmount String - the whole dollar amount of annual taxes paid.
     */
    public void setAnnualTaxes(final String taxesAsAmount) {
        annualTaxesInput().sendKeys(taxesAsAmount);
    }

    /**
     * Enter the 'Annual Insurance' value as a dollar amount.
     *
     * @param insurancePaid String - the whole dollar amount of annual insurance paid.
     */
    public void setAnnualInsurance(final String insurancePaid) {
        annualInsuranceInput().sendKeys(insurancePaid);
    }

    /**
     * Enter the 'Annual PMI' value as a percentage.
     *
     * @param pmiAmount String - the annual PMI percentage.
     */
    public void setAnnualPmi(final String pmiAmount) {
        annualPmiInput().sendKeys(pmiAmount);
    }

    /**
     * Click the 'Next' button.
     */
    public void clickNextButton() {
        nextButton().click();
    }

    /**
     * Click the 'Show Results' button.
     */
    public void clickShowResultsButton() {
        showResultsButton().click();
    }

    /**
     * Retrieve the "Your Monthly Payments Could Be" amount displayed on the results page.
     */
    public String getMonthlyPaymentResult() {
        return monthlyPaymentResultLabel().getText();
    }

}
