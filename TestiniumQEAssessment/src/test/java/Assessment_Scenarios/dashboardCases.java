package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dashboardCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;

    // This method runs before all the test methods to set up the WebDriver, login, and navigate to the dashboard
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize page objects to interact with web pages and navigate to login page
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();

        // Initialize other page locators
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);  // Initialize Dashboard_Locators

        // Perform login with valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void challengeNameTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the challenge name field label is displayed correctly
        WebElement challengeName = dashboardActions.getChallengeName();
        softAssert.assertTrue(challengeName.isDisplayed(),"Challenge name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedChallengeName = challengeName.getText();
        softAssert.assertTrue(displayedChallengeName.contains("QA ve/veya QE Uygulaması 28.01.25"), "Expected challenge name is 'QA ve/veya QE Uygulaması 28.01.25' but got " + displayedChallengeName);

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void startTimeTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the start time field label is displayed correctly
        WebElement startTime = dashboardActions.getStartTime();
        softAssert.assertTrue(startTime.isDisplayed(),"Start time is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedStartTime = startTime.getText();
        softAssert.assertTrue(displayedStartTime.contains("28-01-2025 11:20:42"), "Expected start time is '28-01-2025 11:20:42' but got " + displayedStartTime);

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void endTimeTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the end time field label is displayed correctly
        WebElement endTime = dashboardActions.getEndTime();
        softAssert.assertTrue(endTime.isDisplayed(),"End time is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedEndTime = endTime.getText();
        softAssert.assertTrue(displayedEndTime.contains("02-02-2025 23:59:42"), "Expected end time is '02-02-2025 23:59:42' but got " + displayedEndTime);

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void managerNameTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the manager name field label is displayed correctly
        WebElement managerName = dashboardActions.getManagerName();
        softAssert.assertTrue(managerName.isDisplayed(),"Manager name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedManagerName = managerName.getText();
        softAssert.assertTrue(displayedManagerName.contains("QAManager"), "Expected manager name is 'QAManager' but got " + displayedManagerName);

        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void companyNameTest() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the company field label is displayed correctly
        WebElement companyName = dashboardActions.getCompanyName();
        softAssert.assertTrue(companyName.isDisplayed(),"Company name is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedCompanyName = companyName.getText();
        softAssert.assertTrue(displayedCompanyName.contains("Testinium"), "Expected company name is 'Testinium' but got " + displayedCompanyName);

        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void moneyTransferButtonTest(){
        SoftAssert softAssert = new SoftAssert();

        // Check if 'OPEN MONEY TRANSFER' button is visible and enabled
        WebElement moneyTransferButton = dashboardActions.getMoneyTransferButton();
        softAssert.assertTrue(moneyTransferButton.isDisplayed(),"Money transfer button is not displayed");
        softAssert.assertTrue(moneyTransferButton.isEnabled(),"Money transfer button is not enabled");

        softAssert.assertAll();
    }

    // This method runs after all the test methods to clean up and quit the WebDriver
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
