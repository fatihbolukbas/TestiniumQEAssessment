package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.EditAccount_Locators;
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

public class editAccountCases {
    WebDriver driver;

    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;
    EditAccount_Locators editAccountActions;

    // This method runs before the tests start and sets up the WebDriver and browser
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
        editAccountActions = new EditAccount_Locators(driver);

        // Perform login actions using valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        // Add a delay to wait for the dashboard to load
        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();

        Thread.sleep(1000);

        myAccountActions.clickEditAccountButton();

        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void closeButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check that the close button is displayed and enabled
        WebElement closeButton = editAccountActions.getCloseButton();
        softAssert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed");
        softAssert.assertTrue(closeButton.isEnabled(), "Close button is not enabled");

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void editAccountPageNameTest() {
        SoftAssert softAssert = new SoftAssert();

        // Get the page name element and verify it's displayed
        WebElement editAccountPage = editAccountActions.getPageName();
        softAssert.assertTrue(editAccountPage.isDisplayed(), "Page name is not displayed");

        // Get the text of the page name and verify it's correct
        String displayedEditAccountPageName = editAccountPage.getText();
        softAssert.assertEquals(displayedEditAccountPageName, "Edit account" , "Page name is wrong");

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void accountNameLabelTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the account name field label is displayed correctly
        WebElement accountNameLabel = editAccountActions.getAccountNameLabel();
        softAssert.assertTrue(accountNameLabel.isDisplayed(), "Account name label is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedAccountNameLabel = accountNameLabel.getText();
        softAssert.assertEquals(displayedAccountNameLabel, "Account name" , "Account name is wrong");

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void accountNameControlTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the pre-filled account name value
        String displayedAccountName = editAccountActions.getAccountName().getAttribute("value");
        softAssert.assertEquals(displayedAccountName, "Fatih", "Account name is not correct");
    }

    @Test(priority = 5)
    public void emptyAccountNameFieldTest() {
        SoftAssert softAssert = new SoftAssert();

        // Clear the account name field and check update button state
        editAccountActions.getAccountName().clear();
        WebElement updateButton= editAccountActions.getUpdateButton();
        softAssert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        softAssert.assertFalse(updateButton.isEnabled(), "Update button is enabled");
        editAccountActions.getCloseButton().click();

        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void onlyNumberAccountNameFieldTest(){
        SoftAssert softAssert = new SoftAssert();

        // Enter a numeric-only account name and check update button state
        editAccountActions.getAccountName().clear();
        editAccountActions.updateAccountName("123456");
        WebElement updateButton= editAccountActions.getUpdateButton();
        softAssert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        softAssert.assertFalse(updateButton.isEnabled(), "Update button is enabled");
        editAccountActions.getCloseButton().click();

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void accountNameUpdateTest() {
        SoftAssert softAssert = new SoftAssert();

        // Update the account name and verify the change is saved
        editAccountActions.getAccountName().clear();
        editAccountActions.updateAccountName("Fatih Bölükbaş");
        WebElement updateButton= editAccountActions.getUpdateButton();
        softAssert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        softAssert.assertTrue(updateButton.isEnabled(), "Update button is not enabled");
        editAccountActions.getUpdateButton().click();

        // Reopen the edit account page to verify the update
        myAccountActions.getEditAccountButton().click();
        String displayedAccountName = editAccountActions.getAccountName().getAttribute("value");
        softAssert.assertEquals(displayedAccountName, "Fatih Bölükbaş", "Account name is not correct");
        editAccountActions.getCloseButton().click();

        softAssert.assertAll();
    }

    // This method resets the account name to its original value after tests and closes the browser
    @AfterTest
    public void afterTest(){
        myAccountActions.clickEditAccountButton();
        editAccountActions.getAccountName().clear();
        editAccountActions.updateAccountName("Fatih");
        editAccountActions.getUpdateButton().click();
        driver.quit();
    }
}
