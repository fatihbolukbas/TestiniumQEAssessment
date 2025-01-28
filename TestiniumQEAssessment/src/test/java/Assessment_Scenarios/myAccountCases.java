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

    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;

    // This method runs before all the test methods to set up the WebDriver, login, and navigate to the dashboard
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();  // Set up WebDriver with ChromeDriver
        driver = new ChromeDriver();  // Initialize ChromeDriver
        driver.manage().window().maximize();  // Maximize the browser window

        // Initialize the LoginPage_Locators and Dashboard_Locators to interact with respective pages
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();  // Navigate to the login page
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);  // Initialize Dashboard_Locators
        myAccountActions = new MyAccount_Locators(driver);

        // Perform login actions using the provided credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        // Adding a delay
        Thread.sleep(1000);

        dashboardActions.clickMoneyTransferButton();
    }

    @Test(priority = 1)
    public void backButtonTests(){
        WebElement backButton = myAccountActions.getBackButton();
        Assert.assertTrue(backButton.isDisplayed(), "Back button is not displayed");
        Assert.assertTrue(backButton.isEnabled(), "Back button is not enabled");
    }

    @Test(priority = 2)
    public void accountNameTest() throws InterruptedException {
        Thread.sleep(150);
        String displayedAccountName = myAccountActions.getAccountName().getText();
        Assert.assertEquals(displayedAccountName, "Fatih");
    }

    @Test(priority = 3)
    public void accountTypeTest() throws InterruptedException {
        Thread.sleep(150);
        String displayedAccountType = myAccountActions.getAccountType().getText();
        Assert.assertEquals(displayedAccountType, "CHECKING");
    }

    @Test(priority = 4)
    public void accountCreationTimeTest() throws InterruptedException {
        Thread.sleep(150);
        String displayedAccountCreationTime = myAccountActions.getAccountCreationTime().getText();
        Assert.assertEquals(displayedAccountCreationTime, "28-01-2025 12:55:08");
    }

    @Test(priority = 5)
    public void accountAmountTest() throws InterruptedException {
        Thread.sleep(150);
        String displayedAount = myAccountActions.getAmount().getText();
        Assert.assertEquals(displayedAount, "10,000,000.00");
    }

    @Test(priority = 6)
    public void transferMoneyButtonTest() {
        WebElement transferMoneyButton = myAccountActions.getTransferMoneyButton();
        Assert.assertTrue(transferMoneyButton.isDisplayed(), "Transfer money button is not displayed");
        Assert.assertTrue(transferMoneyButton.isEnabled(), "Transfer money button is not enabled");
    }

    @Test(priority = 7)
    public void addMoneyButtonTest() throws InterruptedException {
        Thread.sleep(150);
        WebElement addMoneyButton = myAccountActions.getAddMoneyButton();
        Assert.assertTrue(addMoneyButton.isDisplayed(), "Add money button is not displayed");
        Assert.assertTrue(addMoneyButton.isEnabled(), "Add money button is not enabled");
    }

    @Test(priority = 8)
    public void editAccountButtonTest() throws InterruptedException {
        Thread.sleep(150);
        WebElement editAccountButton = myAccountActions.getEditAccountButton();
        Assert.assertTrue(editAccountButton.isDisplayed(), "Edit account button is not displayed");
        Assert.assertTrue(editAccountButton.isEnabled(), "Edit account button is not enabled");
    }

}
