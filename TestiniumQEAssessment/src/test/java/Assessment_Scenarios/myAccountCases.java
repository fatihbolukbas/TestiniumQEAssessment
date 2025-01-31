package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myAccountCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;

    // This method runs before the tests start and sets up the WebDriver and browser
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // Maximize the browser window

        // Initialize page objects to interact with web pages and navigate to login page
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();

        // Initialize page locators
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);
        myAccountActions = new MyAccount_Locators(driver);

        // Perform login with valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();
    }

    //Test to verify the "Back" button is displayed and enabled.
    @Test(priority = 1)
    public void backButtonTests() {
        SoftAssert softAssert = new SoftAssert();

        // Check that the back button is displayed and enabled
        WebElement backButton = myAccountActions.getBackButton();
        softAssert.assertTrue(backButton.isDisplayed(), "Back button is not displayed");
        softAssert.assertTrue(backButton.isEnabled(), "Back button is not enabled");
    }

    @Test(priority = 2)
    public void accountNameFieldLabelTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Verify the account name field label is displayed correctly
        Thread.sleep(1000);
        WebElement accountNameLabel = myAccountActions.getAccountNameFieldLabel();
        softAssert.assertTrue(accountNameLabel.isDisplayed(), "Account name field is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedAccountNameLabel = accountNameLabel.getText();
        softAssert.assertTrue(displayedAccountNameLabel.equals("Account name"), "Expected field label 'Account name', but got " + displayedAccountNameLabel);
    }

    // Test to verify the account name is displayed correctly.
    @Test(priority = 3)
    public void accountNameTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Check the account name to confirm it matches the expected value
        Thread.sleep(150);
        String displayedAccountName = myAccountActions.getAccountName().getText();
        softAssert.assertEquals(displayedAccountName, "Fatih", "Expected account name 'Fatih', but got " + displayedAccountName);
    }

    @Test(priority = 4)
    public void accountTypeFieldLabelTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the account type field label is displayed correctly
        WebElement accountTypeLabel = myAccountActions.getAccountTypeFieldLabel();
        softAssert.assertTrue(accountTypeLabel.isDisplayed(), "Account type field is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedAccountTypeLabel = accountTypeLabel.getText();
        softAssert.assertEquals(displayedAccountTypeLabel, "Account type", "Expected field label 'Account type', but got " + displayedAccountTypeLabel);
    }

    @Test(priority = 5)
    public void accountTypeTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Check the account type to confirm it matches the expected value
        Thread.sleep(150);
        String displayedAccountType = myAccountActions.getAccountType().getText();
        softAssert.assertEquals(displayedAccountType, "CHECKING", "Expected account type 'CHECKING', but got " + displayedAccountType);
    }

    @Test(priority = 6)
    public void creationTimeFieldLabelTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the creation time field label is displayed correctly
        WebElement creationTimeLabel = myAccountActions.getCreationTimeFieldLabel();
        softAssert.assertTrue(creationTimeLabel.isDisplayed(), "Creation time field is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedCreationTimeLabel = creationTimeLabel.getText();
        softAssert.assertEquals(displayedCreationTimeLabel, "Creation time", "Expected field label 'Creation time', but got " + displayedCreationTimeLabel);
    }

    //Test to verify the account creation time is displayed correctly.
    @Test(priority = 7)
    public void accountCreationTimeTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Check the creation time to confirm it matches the expected value
        Thread.sleep(150);
        String displayedAccountCreationTime = myAccountActions.getAccountCreationTime().getText();
        softAssert.assertEquals(displayedAccountCreationTime, "28-01-2025 12:55:08", "Expected creation time '28-01-2025 12:55:08', but got " + displayedAccountCreationTime);
    }

    @Test(priority = 8)
    public void amountFieldLabelTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the amount field label is displayed correctly
        WebElement amountLabel = myAccountActions.getAmountFieldLabel();
        softAssert.assertTrue(amountLabel.isDisplayed(), "Amount field is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedAmountLabel = amountLabel.getText();
        softAssert.assertEquals(displayedAmountLabel, "Amount", "Expected field label 'Amount', but got " + displayedAmountLabel);
    }

    //Test to verify the account balance/amount is displayed correctly.
    @Test(priority = 9)
    public void accountAmountTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Verify the account balance is not below zero
        Thread.sleep(150);  // Short delay to ensure element is visible
        String displayedAmount = myAccountActions.getAmount().getText();
        double amount = Double.parseDouble(displayedAmount.replace(",", "").trim());
        softAssert.assertTrue(amount >= 0, "Account balance can not go below zero");
    }

    @Test(priority = 10)
    public void transferMoneyButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check if 'TRANSFER MONEY' is visible and enabled
        WebElement transferMoneyButton = myAccountActions.getTransferMoneyButton();
        softAssert.assertTrue(transferMoneyButton.isDisplayed(), "Transfer money button is not displayed");
        softAssert.assertTrue(transferMoneyButton.isEnabled(), "Transfer money button is not enabled");
    }

    @Test(priority = 11)
    public void addMoneyButtonTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Check if 'ADD MONEY' is visible and enabled
        Thread.sleep(150);  // Short delay to ensure element is visible
        WebElement addMoneyButton = myAccountActions.getAddMoneyButton();
        softAssert.assertTrue(addMoneyButton.isDisplayed(), "Add money button is not displayed");
        softAssert.assertTrue(addMoneyButton.isEnabled(), "Add money button is not enabled");
    }

    @Test(priority = 12)
    public void editAccountButtonTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Check if 'EDIT ACCOUNT' is visible and enabled
        Thread.sleep(150);  // Short delay to ensure element is visible
        WebElement editAccountButton = myAccountActions.getEditAccountButton();
        softAssert.assertTrue(editAccountButton.isDisplayed(), "Edit account button is not displayed");
        softAssert.assertTrue(editAccountButton.isEnabled(), "Edit account button is not enabled");
    }

    // This method runs after all the test methods and quits the WebDriver
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
