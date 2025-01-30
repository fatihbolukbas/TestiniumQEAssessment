package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dashboardCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;

    // This method runs before all the test methods to set up the WebDriver, login, and navigate to the dashboard
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // WebDriver setup and navigate to login page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize page objects to interact with web pages
        homePage = new LoginPage_Locators(driver);

        // Initialize other page locators
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);  // Initialize Dashboard_Locators

        // Perform login with valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        Thread.sleep(1000);
    }

    // Test to verify the functionality of the "Money Transfer" button on the dashboard
    @Test(priority = 1)
    public void moneyTransferButtonTest(){
        // Get the "Money Transfer" button from the dashboard
        WebElement transferButton = dashboardActions.getMoneyTransferButton();

        // Assert that the "Money Transfer" button is displayed on the page
        Assert.assertTrue(transferButton.isDisplayed(), "Transfer button is not displayed");

        // Assert that the "Money Transfer" button is enabled and can be interacted with
        Assert.assertTrue(transferButton.isEnabled(), "Transfer button is not enabled");

        // Click the "Money Transfer" button to initiate the transfer process
        dashboardActions.clickMoneyTransferButton();
    }

    // This method runs after all the test methods to clean up and quit the WebDriver
    @AfterTest
    public void afterTest(){
        driver.quit();  // Quit the browser and end the session
    }
}
