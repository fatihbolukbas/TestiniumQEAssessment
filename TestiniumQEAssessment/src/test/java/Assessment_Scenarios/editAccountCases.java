package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.EditAccount_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class editAccountCases {
    WebDriver driver;

    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;
    EditAccount_Locators editAccountActions;

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

        editAccountActions.clickEditAccountButton();

        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void closeButtonTest() {
        WebElement closeButton = editAccountActions.getCloseButton();
        Assert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed");
        Assert.assertTrue(closeButton.isEnabled(), "Close button is not enabled");
    }

    @Test(priority = 2)
    public void accountNameControlTest() {
        String displayedAccountName = editAccountActions.getAccountNameField().getAttribute("value");
        Assert.assertEquals(displayedAccountName, "Fatih", "Account name is not correct");
    }

    @Test(priority = 3)
    public void emptyAccountNameFieldTest() {
        editAccountActions.getAccountNameField().clear();
        WebElement updateButton= editAccountActions.getUpdateButton();
        Assert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        Assert.assertFalse(updateButton.isEnabled(), "Update button is enabled");
        editAccountActions.getCloseButton().click();
    }

    @Test(priority = 4)
    public void onlyNumberAccountNameFieldTest(){
        editAccountActions.getAccountNameField().clear();
        editAccountActions.updateAccountName("123456");
        WebElement updateButton= editAccountActions.getUpdateButton();
        Assert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        Assert.assertFalse(updateButton.isEnabled(), "Update button is enabled");
        editAccountActions.getCloseButton().click();
    }

    @Test(priority = 5)
    public void accountNameUpdateTest() throws InterruptedException {
        editAccountActions.getAccountNameField().clear();
        editAccountActions.updateAccountName("Fatih Bölükbaş");
        WebElement updateButton= editAccountActions.getUpdateButton();
        Assert.assertTrue(updateButton.isDisplayed(), "Update button is not displayed");
        Assert.assertTrue(updateButton.isEnabled(), "Update button is not enabled");
        editAccountActions.getUpdateButton().click();
        //Thread.sleep(3000);

        editAccountActions.getEditAccountButton().click();
        String displayedAccountName = editAccountActions.getAccountNameField().getAttribute("value");
        Assert.assertEquals(displayedAccountName, "Fatih Bölükbaş", "Account name is not correct");
        //Thread.sleep(1000);
        editAccountActions.getCloseButton().click();

    }

    @AfterTest
    public void afterTest(){
        editAccountActions.clickEditAccountButton();
        editAccountActions.getAccountNameField().clear();
        editAccountActions.updateAccountName("Fatih");
        editAccountActions.getUpdateButton().click();
        driver.quit();
    }
}
