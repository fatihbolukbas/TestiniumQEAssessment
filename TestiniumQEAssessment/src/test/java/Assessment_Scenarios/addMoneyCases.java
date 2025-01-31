package Assessment_Scenarios;

import Assessment_Scenarios_Locators.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class addMoneyCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;
    AddMoney_Locators addMoneyActions;
    TransferMoney_Locators transferMoneyActions;

    // This method runs before the tests start and sets up the WebDriver and browser
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize page objects to interact with web pages and navigate to login page
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();

        // Initialize page locators
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);
        myAccountActions = new MyAccount_Locators(driver);
        addMoneyActions = new AddMoney_Locators(driver);
        transferMoneyActions = new TransferMoney_Locators(driver);

        // Perform login with valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();
        Thread.sleep(1000);

        // Click on the Add Money button to open Add Money page
        myAccountActions.getAddMoneyButton().click();
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void addMoneyPageNameTest() {
        SoftAssert softAssert = new SoftAssert();

        // Get the page name element and verify it's displayed
        WebElement addMoneyPage = addMoneyActions.getPageName();
        softAssert.assertTrue(addMoneyPage.isDisplayed(), "Page name is not displayed");

        // Get the text of the page name and verify it's correct
        String displayedAddMoneyPageName = addMoneyPage.getText();
        softAssert.assertEquals(displayedAddMoneyPageName, "Add money", "Page name is wrong");

        softAssert.assertAll(); // Assert all to report the results
    }

    @Test(priority = 2)
    public void closeButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check that the close button is displayed and enabled
        WebElement closeButton = addMoneyActions.getCloseButton();
        softAssert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed");
        softAssert.assertTrue(closeButton.isEnabled(), "Close button is not enabled");

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void cardNumberLabelTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the card number field label is displayed correctly
        WebElement cardNumberLabel = addMoneyActions.getCardNumberName();
        softAssert.assertTrue(cardNumberLabel.isDisplayed(), "Card number label is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedCardNumberName = cardNumberLabel.getText();
        softAssert.assertEquals(displayedCardNumberName, "Card number", "Expected field label 'Card number', but got " + displayedCardNumberName);

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void cardNumberTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the card number input field is displayed and enabled
        WebElement cardNumber = addMoneyActions.getCardNumber();
        softAssert.assertTrue(cardNumber.isDisplayed(), "Card number field is not displayed");
        softAssert.assertTrue(cardNumber.isEnabled(), "Card number field is not enabled");

        // Verify the card number field is empty by default
        String displayedCardNumber = cardNumber.getDomAttribute("value");
        softAssert.assertTrue(displayedCardNumber.isEmpty(), "Card number field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void cardHolderFieldTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify cardholder name label is displayed correctly
        WebElement cardHolderName = addMoneyActions.getCardHolderName();
        softAssert.assertTrue(cardHolderName.isDisplayed(), "Card holder name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedCardHolderName = cardHolderName.getText();
        softAssert.assertEquals(displayedCardHolderName, "Card holder", "Expected field label 'Card holder', but got " + displayedCardHolderName);

        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void cardHolderTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check cardholder input field
        WebElement cardHolder = addMoneyActions.getCardHolder();
        softAssert.assertTrue(cardHolder.isDisplayed(), "Card holder field is not displayed");
        softAssert.assertTrue(cardHolder.isEnabled(), "Card holder field is not enabled");

        // Verify that the cardholder field is empty initially
        String displayedCardHolder = cardHolder.getDomAttribute("value");
        softAssert.assertTrue(displayedCardHolder.isEmpty(), "Card holder field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void expiryDateFieldTests() {
        SoftAssert softAssert = new SoftAssert();

        // Verify expiry date field label is displayed
        WebElement expiryDateName = addMoneyActions.getExpireDateName();
        softAssert.assertTrue(expiryDateName.isDisplayed(), "Expiry date name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedExpiryDateName = expiryDateName.getText();
        softAssert.assertEquals(displayedExpiryDateName, "Expiry date", "Expected field label 'Expiry date', but got " + displayedExpiryDateName);

        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void expiryDateTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify expiry date field is displayed and enabled
        WebElement expiryDate = addMoneyActions.getExpireDate();
        softAssert.assertTrue(expiryDate.isDisplayed(), "Expiry date field is not displayed");
        softAssert.assertTrue(expiryDate.isEnabled(), "Expiry date field is not enabled");

        // Verify that the expiry date field is empty
        String displayedExpiryDate = expiryDate.getDomAttribute("value");
        softAssert.assertTrue(displayedExpiryDate.isEmpty(), "Expiry date field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void cvvFieldTests() {
        SoftAssert softAssert = new SoftAssert();

        // Check if CVV field label is displayed
        WebElement cvvName = addMoneyActions.getCvvName();
        softAssert.assertTrue(cvvName.isDisplayed(), "CVV name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedCvvName = cvvName.getText();
        softAssert.assertEquals(displayedCvvName, "CVV", "Expected field label 'CVV', but got " + displayedCvvName);

         softAssert.assertAll();
    }

    @Test(priority = 10)
    public void cvvTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify CVV input field is displayed and enabled
        WebElement cvv = addMoneyActions.getCvv();
        softAssert.assertTrue(cvv.isDisplayed(), "CVV field is not displayed");
        softAssert.assertTrue(cvv.isEnabled(), "CVV field is not enabled");

        // Ensure CVV field is empty initially
        String displayedCvv = cvv.getDomAttribute("value");
        softAssert.assertTrue(displayedCvv.isEmpty(), "CVV field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 11)
    public void amountFieldTests() {
        SoftAssert softAssert = new SoftAssert();

        // Verify that the amount label is displayed correctly
        WebElement amountName = addMoneyActions.getAmountName();
        softAssert.assertTrue(amountName.isDisplayed(), "Amount name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedAmountName = amountName.getText();
        softAssert.assertEquals(displayedAmountName, "Amount", "Expected field label 'Amount', but got " + displayedAmountName);

        softAssert.assertAll();
    }

    @Test(priority = 12)
    public void amountTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify amount input field
        WebElement amount = addMoneyActions.getAmount();
        softAssert.assertTrue(amount.isDisplayed(), "Amount field is not displayed");
        softAssert.assertTrue(amount.isEnabled(), "Amount field is not enabled");

        // Ensure the amount field is initially empty
        String displayedAmount = amount.getDomAttribute("value");
        softAssert.assertTrue(displayedAmount.isEmpty(), "Amount field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void validationTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Simulate clicking the add button and check for validation messages
        addMoneyActions.getAddButton().click();
        Thread.sleep(1000);

        WebElement cardNumberValidation = addMoneyActions.getCardNumberValidation();
        softAssert.assertTrue(cardNumberValidation.isDisplayed(), "Card number required validation message is not displayed");

        WebElement cardHolderValidation = addMoneyActions.getCardHolderValidation();
        softAssert.assertTrue(cardHolderValidation.isDisplayed(), "Card holder validation message is not displayed");

        WebElement expireDateValidation = addMoneyActions.getExpireDateValidation();
        softAssert.assertTrue(expireDateValidation.isDisplayed(), "Expire date required validation message is not displayed");

        WebElement cvvValidation = addMoneyActions.getCvvValidation();
        softAssert.assertTrue(cvvValidation.isDisplayed(), "CVV validation message is not displayed");

        WebElement amountValidation = addMoneyActions.getAmountValidation();
        softAssert.assertTrue(amountValidation.isDisplayed(), "Amount validation message is not displayed");

        softAssert.assertAll();
    }

    @Test(priority = 14)
    public void addButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check if Add button is visible and enabled
        WebElement addButton = addMoneyActions.getAddButton();
        softAssert.assertTrue(addButton.isDisplayed(), "Add button is not displayed");
        softAssert.assertTrue(addButton.isEnabled(), "Add button is not enabled");

        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void addingMoneyTests() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Add money by entering the details and verify the balance
        WebElement addButton = addMoneyActions.getAddButton();
        WebElement accountBalanceElement = myAccountActions.getAmount();

        addMoneyActions.enterCardNumber("1234 1234 1234 1234");
        addMoneyActions.enterCardHolder("Fatih Bölükbaş");
        addMoneyActions.enterExpireDate("1026");
        Thread.sleep(500);
        addMoneyActions.enterCvv("110");
        addMoneyActions.enterAmount("1000");
        Thread.sleep(2000);

        // Parse entered amount and initial balance
        double enteredAmount = parseAmount(addMoneyActions.getEnteredAmount());
        double initialBalance = parseAmount(accountBalanceElement.getText());

        // Click Add button to complete the transaction
        softAssert.assertTrue(addButton.isDisplayed(), "Add button is not displayed");
        softAssert.assertTrue(addButton.isEnabled(), "Add button is not enabled");
        addButton.click();
        Thread.sleep(2000);

        // Verify that the updated balance is correct
        double updatedBalance = parseAmount(myAccountActions.getAmount().getText());
        double expectedBalance = initialBalance + enteredAmount;
        softAssert.assertEquals(updatedBalance, expectedBalance, "New balance is not equal to expected balance of " + expectedBalance);

        softAssert.assertAll();
    }

    /**
     *  💡 parseAmount() method:
     *  - Removes formatting characters like commas and spaces.
     *  - Converts the cleaned string into a double for further calculations.
     *
     *  Example:
     *  "1,000.50" → 1000.50 (double)
     *  "5000.75" → 5000.75 (double)
     */

    private double parseAmount(String amount) {
        // Helper method to remove commas and spaces, then parse the amount
        if (amount == null || amount.isEmpty()) {
            return 0.0; // Return 0 if the amount is null or empty
        }
        return Double.parseDouble(amount.replace(",", "").replace(" ", ""));
    }

    // This method runs after all the test methods and quits the WebDriver
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
