import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class representing the https://www.mortgageloan.com/calculator page.
 */
public class MortgageCalculatorPage {

    private static WebDriver chromeDriver = new ChromeDriver();

    /**
     * Constructor which will open the browser to the expected URL and maximize the window.
     */
    public MortgageCalculatorPage() {
        chromeDriver.get("https://www.mortgageloan.com/calculator");
        waitForCalculatorToLoad();
        chromeDriver.manage().window().maximize();
        waitForCalculatorToLoad();
    }

    /**
     * Close the browser and quit the web driver.
     */
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
        return monthlyPaymentResultLabel().isDisplayed();
    }

    //////////////////////////////////////////////////////////
    // Elements of the page.
    //////////////////////////////////////////////////////////

    /**
     * The 'Annual Insurance' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement annualInsuranceInput() {
        return chromeDriver.findElement(By.id("calculator_widget_Insurance"));
    }

    /**
     * The 'Annual PMI' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement annualPmiInput() {
        return chromeDriver.findElement(By.id("calculator_widget_PMI"));
    }

    /**
     * The 'Annual Taxes' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement annualTaxesInput() {
        return chromeDriver.findElement(By.id("calculator_widget_PropertyTaxes"));
    }

    /**
     * The mortgage calculator widget.
     *
     * @return WebElement - the mortgage calculator.
     */
    private WebElement calculator() {
        return chromeDriver.findElement(By.id("calculator-form-wizard"));
    }

    /**
     * The 'Home Value' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement homeValueInput() {
        return chromeDriver.findElement(By.id("calculator_widget_HomeValue"));
    }

    /**
     * The 'Interest Rate' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement interestRateInput() {
        return chromeDriver.findElement(By.id("calculator_widget_interest"));
    }

    /**
     * The 'Length' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement lengthOfLoanInput() {
        return chromeDriver.findElement(By.id("calculator_widget_Length"));
    }

    /**
     * The 'Loan Amount' input element.
     *
     * @return WebElement - the element found by its id.
     */
    private WebElement loanAmountInput() {
        return chromeDriver.findElement(By.id("calculator_widget_amount"));
    }

    /**
     * The 'Loan To Value Ratio' results label.
     *
     * @return WebElement - the label displaying the resulting Loan To Value Ratio, found by its xpath locator.
     */
    private WebElement loanToValueRatioResultLabel() {
        return chromeDriver.findElement(By.xpath("//th[text()='Loan To Value Ratio']/..//td"));
    }

    /**
     * The 'Total Monthly Payments' results label.
     *
     * @return WebElement - the label displaying the resulting monthly payment amount, found by its xpath locator.
     */
    private WebElement monthlyPaymentResultLabel() {
        return chromeDriver.findElement(By.xpath("//th[text()='Total Monthly Payments']/..//td"));
    }

    /**
     * The 'Monthly Principal & Interests' label displaying the calculated results.
     *
     * @return WebElement - the label displaying the resulting principal and interest payments, found by its xpath locator.
     */
    private WebElement monthlyPrincipleAndInterestsLabel() {
        return chromeDriver.findElement(By.xpath("//th[text()='Monthly Principal & Interests']/..//td"));
    }

    /**
     * The 'Next' button.
     *
     * @return WebElement - the button found by its css locator.
     */
    private WebElement nextButton() {
        return chromeDriver.findElement(By.cssSelector("#calculator-form > div > ul > li.next > a.next-button"));
    }

    /**
     * The 'Show Results' button.
     *
     * @return WebElement - the button found by its css locator.
     */
    private WebElement showResultsButton() {
        return chromeDriver.findElement(By.cssSelector("#calculator-form > div > ul > li.finish > a.finish-button"));
    }

    //////////////////////////////////////////////////////////
    // Helper methods.
    //////////////////////////////////////////////////////////

    /**
     * Ensure that we can access the element by scrolling to it.
     *
     * @param element WebElement - the element to scroll to.
     */
    private void scrollToElement(final WebElement element) {
        ((JavascriptExecutor)chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Given a specified input element, enter in the input text.
     *
     * @param inputElement WebElement - the input element to enter text into.
     * @param input String - the text to enter into the input element.
     */
    private void enter(WebElement inputElement, final String input) {
        inputElement.clear();
        inputElement.sendKeys(input);
    }

    /**
     * Enter the 'Loan Amount' value.
     *
     * @param loanAmount String - the amount requested for the loan, as whole dollars.
     */
    public void setLoanAmount(final String loanAmount) {
        enter(loanAmountInput(), loanAmount);
    }

    /**
     * Enter the 'Interest Rate' percentage.
     *
     * @param rate String - the interest rate as a percentage.
     */
    public void setInterestRate(final String rate) {
        enter(interestRateInput(), rate);
    }

    /**
     * Enter the length of time the loan is for.
     *
     * @param length String - the length of time in years.
     */
    public void setLengthOfLoan(final String length) {
        enter(lengthOfLoanInput(), length);
    }

    /**
     * Enter the value of the home to be mortgaged.
     *
     * @param homeValue String - the value of the home.
     */
    public void setHomeValue(final String homeValue) {
        enter(homeValueInput(), homeValue);
    }

    /**
     * Enter the 'Annual Taxes' value as a dollar amount.
     *
     * @param taxesAsAmount String - the whole dollar amount of annual taxes paid.
     */
    public void setAnnualTaxes(final String taxesAsAmount) {
        enter(annualTaxesInput(), taxesAsAmount);
    }

    /**
     * Enter the 'Annual Insurance' value as a dollar amount.
     *
     * @param insurancePaid String - the whole dollar amount of annual insurance paid.
     */
    public void setAnnualInsurance(final String insurancePaid) {
        enter(annualInsuranceInput(), insurancePaid);
    }

    /**
     * Enter the 'Annual PMI' value as a percentage.
     *
     * @param pmiAmount String - the annual PMI percentage.
     */
    public void setAnnualPmi(final String pmiAmount) {
        enter(annualPmiInput(), pmiAmount);
    }

    /**
     * Click the 'Next' button.
     */
    public void clickNextButton() {
        scrollToElement(calculator());
        nextButton().click();
    }

    /**
     * Click the 'Show Results' button.
     */
    public void clickShowResultsButton() {
        scrollToElement(calculator());
        showResultsButton().click();
    }

    /**
     * Retrieve the "Total Monthly Payments" amount displayed on the results page.
     */
    public String getMonthlyPaymentResult() {
        return monthlyPaymentResultLabel().getText();
    }

    /**
     * Retrieve the "Monthly Principal & Interests" amount displayed on the results page.
     */
    public String getMonthlyPrincipleAndInterestsResult() {
        return monthlyPrincipleAndInterestsLabel().getText();
    }

    /**
     * Retrieve the "Loan To Value Ratio" amount displayed on the results page.
     */
    public String getLoanToValueRatioResult() {
        return loanToValueRatioResultLabel().getText();
    }

    /**
     * Wait no longer than 10 seconds for the calculator to appear.
     */
    public void waitForCalculatorToLoad() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(calculator()));
    }

}
