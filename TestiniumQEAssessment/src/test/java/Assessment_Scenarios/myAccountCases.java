package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myAccountCases {

    WebDriver driver;

    // Declare instances of page locator classes
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;

    //This method is executed before any test cases. It initializes the WebDriver, logs in, and navigates to the account dashboard.
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // Set up WebDriver using WebDriverManager and initialize ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // Maximize the browser window

        // Initialize page locators for login, dashboard, and account pages
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();  // Navigate to the login page
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);
        myAccountActions = new MyAccount_Locators(driver);

        // Perform login actions using valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        // Add a delay to wait for the dashboard to load
        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();
    }

    //Test to verify the "Back" button is displayed and enabled.
    @Test(priority = 1)
    public void backButtonTests() {
        WebElement backButton = myAccountActions.getBackButton();
        Assert.assertTrue(backButton.isDisplayed(), "Back button is not displayed");
        Assert.assertTrue(backButton.isEnabled(), "Back button is not enabled");
    }

    // Test to verify the account name is displayed correctly.
    @Test(priority = 2)
    public void accountNameTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        String displayedAccountName = myAccountActions.getAccountName().getText();
        Assert.assertEquals(displayedAccountName, "Fatih", "Account name does not match the expected value");
    }

    //Test to verify the account type is displayed correctly.
    @Test(priority = 3)
    public void accountTypeTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        String displayedAccountType = myAccountActions.getAccountType().getText();
        Assert.assertEquals(displayedAccountType, "CHECKING", "Account type does not match the expected value");
    }

    //Test to verify the account creation time is displayed correctly.
    @Test(priority = 4)
    public void accountCreationTimeTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        String displayedAccountCreationTime = myAccountActions.getAccountCreationTime().getText();
        Assert.assertEquals(displayedAccountCreationTime, "28-01-2025 12:55:08", "Account creation time is incorrect");
    }

    //Test to verify the account balance/amount is displayed correctly.

    @Test(priority = 5)
    public void accountAmountTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        String displayedAmount = myAccountActions.getAmount().getText();
        Assert.assertEquals(displayedAmount, "10,000,000.00", "Account amount does not match the expected value");
    }

    // Test to verify the "Transfer Money" button is displayed and enabled.
    @Test(priority = 6)
    public void transferMoneyButtonTest() {
        WebElement transferMoneyButton = myAccountActions.getTransferMoneyButton();
        Assert.assertTrue(transferMoneyButton.isDisplayed(), "Transfer money button is not displayed");
        Assert.assertTrue(transferMoneyButton.isEnabled(), "Transfer money button is not enabled");
    }

    //Test to verify the "Add Money" button is displayed and enabled.

    @Test(priority = 7)
    public void addMoneyButtonTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        WebElement addMoneyButton = myAccountActions.getAddMoneyButton();
        Assert.assertTrue(addMoneyButton.isDisplayed(), "Add money button is not displayed");
        Assert.assertTrue(addMoneyButton.isEnabled(), "Add money button is not enabled");
    }

    //Test to verify the "Edit Account" button is displayed and enabled.
    @Test(priority = 8)
    public void editAccountButtonTest() throws InterruptedException {
        Thread.sleep(150);  // Short delay to ensure element is visible
        WebElement editAccountButton = myAccountActions.getEditAccountButton();
        Assert.assertTrue(editAccountButton.isDisplayed(), "Edit account button is not displayed");
        Assert.assertTrue(editAccountButton.isEnabled(), "Edit account button is not enabled");
    }
}
