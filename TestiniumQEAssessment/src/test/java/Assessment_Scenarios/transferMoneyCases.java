package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import Assessment_Scenarios_Locators.TransferMoney_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class transferMoneyCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;
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
        homePage.goTo();  // Navigate to the login page

        // Initialize page locators
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);
        myAccountActions = new MyAccount_Locators(driver);
        transferMoneyActions = new TransferMoney_Locators(driver);

        // Perform login with valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();
        Thread.sleep(1000);

        // // Click on the 'TRASNFER MONEY' button to open Add Money page
        myAccountActions.clickTransferMoneyButton();
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void closeButtonTest() {
        SoftAssert softAssert = new SoftAssert();
        // Check that the close button is displayed and enabled
        WebElement closeButton = transferMoneyActions.getCloseButton();
        softAssert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed");
        softAssert.assertTrue(closeButton.isEnabled(), "Close button is not enabled");
    }

    @Test(priority = 2)
    public void senderAccountTest() {
        // Validate sender account information
        WebElement senderAccount = transferMoneyActions.getSenderAccount();
        Assert.assertTrue(senderAccount.isDisplayed(), "Sender account is not displayed");
        Assert.assertTrue(senderAccount.isEnabled(), "Sender account is not enabled");

        // Check if the displayed sender account name matches the expected name
        String displayedSenderAccountName = senderAccount.getText();
        Assert.assertEquals(displayedSenderAccountName, "Fatih", "Sender account name is not correct");
    }

    @Test(priority = 3)
    public void receiverAccountTest() {
        // Validate receiver account dropdown
        WebElement receiverAccountDropdown = transferMoneyActions.getReceiverAccount();
        Assert.assertTrue(receiverAccountDropdown.isDisplayed(), "Receiver account is not displayed");
        Assert.assertTrue(receiverAccountDropdown.isEnabled(), "Receiver account is not enabled");

        // Get the list of available options in the dropdown
        Select dropdown = new Select(receiverAccountDropdown);
        List<String> actualOptions = dropdown.getOptions().stream()
                .map(WebElement::getText)
                .toList();

        // Expected options in the dropdown
        List<String> expectedOptions = List.of("Testinium-1", "Testinium-2", "Testinium-3", "Testinium-4", "Testinium-5");

        // Ensure the expected options are present
        for (String option : expectedOptions) {
            Assert.assertTrue(actualOptions.contains(option), "Option '" + option + "' is missing from the dropdown");
        }
    }

    @Test(priority = 4)
    public void moneySendingTest() throws InterruptedException {
        // Retrieve necessary page elements
        WebElement amountInput = transferMoneyActions.getAmount();
        WebElement accountBalanceElement = myAccountActions.getAmount();
        WebElement sendButton = transferMoneyActions.getSendButton();

        // Ensure the amount input field is visible and enabled
        Assert.assertTrue(amountInput.isDisplayed(), "Amount input is not displayed");
        Assert.assertTrue(amountInput.isEnabled(), "Amount input is not enabled");

        // Enter the transfer amount into the input field
        String transferAmount = "900";
        transferMoneyActions.enterAmount(transferAmount);

        // Parse the entered amount and the current account balance
        double enteredAmount = parseAmount(transferMoneyActions.getEnteredAmount());
        double initialBalance = parseAmount(accountBalanceElement.getText());

        // Check if the entered amount does not exceed the current balance
        Assert.assertTrue(enteredAmount <= initialBalance,
                "The amount to be transferred exceeds the account balance.");

        // Verify that the send button is visible and enabled
        Assert.assertTrue(sendButton.isDisplayed(), "Send button is not displayed");
        Assert.assertTrue(sendButton.isEnabled(), "Send button is not enabled");

        // Click the send button to proceed with the transfer
        sendButton.click();
        Thread.sleep(1000); // Wait for the transaction to complete

        // Retrieve the updated account balance after the transfer
        double updatedBalance = parseAmount(myAccountActions.getAmount().getText());

        // Validate that the new balance equals the previous balance minus the transferred amount
        double expectedBalance = initialBalance - enteredAmount;
        Assert.assertEquals(updatedBalance, expectedBalance,
                "New balance is not equal to previous balance minus transferred amount.");
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
        if (amount == null || amount.isEmpty()) {
            return 0.0; // Return 0 if the amount is null or empty
        }
        return Double.parseDouble(amount.replace(",", "").replace(" ", "")); // Remove commas and spaces and parse to double
    }
}
