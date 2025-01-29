package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.EditAccount_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        editAccountActions.clickEditAccountButton();
    }

    @Test(priority = 1)
    public void accountNameTest(){
        String displayedAccountName = editAccountActions.getAccountNameField().getText();
        Assert.assertEquals(displayedAccountName, "Fatih", "Account name is not correct");
    }


}
