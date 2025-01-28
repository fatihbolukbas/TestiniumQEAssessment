package Assessment_Scenarios;

import Assessment_Scenarios_Locators.LoginPage_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginPageCases {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // LoginPage_Locators instance for interacting with login page elements
    LoginPage_Locators loginActions, homePage;

    // This method runs before the tests start and sets up the WebDriver and browser
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();  // Set up WebDriver with ChromeDriver
        driver = new ChromeDriver();  // Initialize ChromeDriver
        driver.manage().window().maximize();  // Maximize the browser window

        // Initialize the LoginPage_Locators to interact with login page elements
        homePage = new LoginPage_Locators(driver);
        homePage.goTo();  // Navigate to the login page
        loginActions = new LoginPage_Locators(driver);  // Another instance for performing actions on login page
    }

    // Test to verify that the login page title is correct
    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = driver.getTitle();  // Get the title of the current page
        // Assert that the title matches the expected value
        Assert.assertEquals(title, "login", "Home page title is wrong");
    }

    // Test to verify that the username field is empty initially
    @Test(priority = 2)
    public void usernameFieldTest(){
        WebElement username = loginActions.getUsernameField();  // Get the username input field
        // Check if the username field is not empty, fail the test if it's not
        if (!username.getText().trim().isEmpty()){
            Assert.fail("Username field is not empty");
        }
        // Enter the test username into the field
        loginActions.enterUsername("fatih.bolukbas");
    }

    // Test to verify that the password field is empty initially
    @Test(priority = 3)
    public void passwordFieldTest(){
        WebElement password = loginActions.getPasswordField();  // Get the password input field
        // Check if the password field is not empty, fail the test if it's not
        if (!password.getText().trim().isEmpty()){
            Assert.fail("Password field is not empty");
        }
        // Enter the test password into the field
        loginActions.enterPassword("159753fatih");
    }

    // Test to verify the login button is displayed and enabled
    @Test(priority = 4)
    public void loginButtonTest(){
        WebElement loginButton = loginActions.getLoginButton();  // Get the login button element
        // Assert that the login button is displayed on the page
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        // Assert that the login button is enabled for interaction
        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        // Click the login button
        loginActions.clickLoginButton();
    }

    // This method runs after all the test methods and quits the WebDriver
    @AfterTest
    public void afterTest(){
        driver.quit();  // Quit the browser and end the session
    }
}
