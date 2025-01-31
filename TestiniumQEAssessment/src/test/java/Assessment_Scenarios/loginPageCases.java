package Assessment_Scenarios;

import Assessment_Scenarios_Locators.LoginPage_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginPageCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Page object locators for each page of the flow
    LoginPage_Locators loginActions, homePage;

    // This method runs before the tests start and sets up the WebDriver and browser
    @BeforeTest
    public void beforeTest() {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize page objects to interact with web pages and navigate to login page
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();

        // Initialize page locators
        loginActions = new LoginPage_Locators(driver);
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        SoftAssert softAssert = new SoftAssert();

        // Test to verify that the login page title is correct
        String title = driver.getTitle();
        softAssert.assertEquals(title, "login", "Home page title is wrong");
    }

    @Test(priority = 2)
    public void usernameFieldTests() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the username field label is displayed correctly
        WebElement usernameLabel = loginActions.getusernameFieldLabel();
        softAssert.assertTrue(usernameLabel.isDisplayed(), "Username label is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedUsernameLabel = usernameLabel.getText();
        softAssert.assertEquals(displayedUsernameLabel, "Enter username*", "Expected field label 'Enter username*', but got " + displayedUsernameLabel);

        // Verify the username input field is displayed and enabled
        WebElement username = loginActions.getUsernameField();
        softAssert.assertTrue(username.isDisplayed(), "Username field is not displayed");
        softAssert.assertTrue(username.isEnabled(), "Username field is not enabled");

        // Verify the card number field is empty by default
        String displayedUsername = username.getDomAttribute("value");
        softAssert.assertTrue(displayedUsername.isEmpty(), "Username field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void passwordFieldTests() {
        SoftAssert softAssert = new SoftAssert();

        // Verify the password field label is displayed correctly
        WebElement passwordLabel = loginActions.getPasswordFieldLabel();
        softAssert.assertTrue(passwordLabel.isDisplayed(), "Password field is not displayed");

        // Check the label text to confirm it matches the expected value
        String displayedPasswordLabel = passwordLabel.getText();
        softAssert.assertEquals(displayedPasswordLabel, "Enter password*", "Expected field label 'Enter password*', but got " + displayedPasswordLabel);

        // Verify the pasword input field is displayed and enabled
        WebElement password = loginActions.getPasswordField();
        softAssert.assertTrue(password.isDisplayed(), "Password field is not displayed");
        softAssert.assertTrue(password.isEnabled(), "Password field is not enabled");

        // Verify the card number field is empty by default
        String displayedPassword = password.getDomAttribute("value");
        softAssert.assertTrue(displayedPassword.isEmpty(), "Password field is not empty");

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validationTests() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Simulate clicking the login button and check for validation messages
        loginActions.getLoginButton().click();
        Thread.sleep(1000);

        // Verify the validation message is displayed correctly
        WebElement validationMessage = loginActions.getValidationMessage();
        softAssert.assertTrue(validationMessage.isDisplayed(), "Validation message is not displayed");
    }

    @Test(priority = 5)
    public void loginButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        // Check if LOGIN button is visible and enabled
        WebElement loginButton = loginActions.getLoginButton();
        softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        softAssert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");

        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void loginTest() {
        SoftAssert softAssert = new SoftAssert();

        // Perform login with valid credentials
        WebElement loginButton = loginActions.getLoginButton();
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");

        // Check if LOGIN button is visible and enabled to click
        softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        softAssert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        loginButton.click();

        softAssert.assertAll();
    }

    // This method runs after all the test methods and quits the WebDriver
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
