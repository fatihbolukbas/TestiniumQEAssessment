package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Locators {
    WebDriver driver; // WebDriver instance to interact with the browser

    // Constructor to initialize WebDriver
    public LoginPage_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the login page (opens the URL)
    public void goTo() {
        driver.get("https://catchylabs-webclient.testinium.com/signIn"); // Navigate to the sign-in page
    }

    // Username field label locator
    By usernameFieldLabel = By.xpath("//div[@class='css-146c3p1 r-1ozpqpt r-g6644c r-1b43r93 r-15zivkp'][1]");
    public WebElement getusernameFieldLabel() {
        return driver.findElement(usernameFieldLabel);
    }

    // Username input field locator
    By usernameField = By.xpath("//input[@placeholder='Username']");
    public WebElement getUsernameField() {
        return driver.findElement(usernameField); // Find and return the username input field element
    }

    // Password field label locator
    By passwordFieldLabel = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-g6644c r-1b43r93 r-15zivkp'])[2]");
    public WebElement getPasswordFieldLabel() {
        return driver.findElement(passwordFieldLabel);
    }

    // Username input field locator
    By passwordField = By.xpath("//input[@placeholder='Password']");
    public WebElement getPasswordField() {
        return driver.findElement(passwordField); // Find and return the password input field element
    }

    // Login button locator
    By loginButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");
    public WebElement getLoginButton() {
        return driver.findElement(loginButton); // Find and return the login button element
    }

    // Validation message locator
    By validationMessage = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[2]/div[.='Username or Password Invalid!']");
    public WebElement getValidationMessage() {
        return driver.findElement(validationMessage);
    }

    // Method to enter the username
    public void enterUsername(String username) {
        WebElement usernameField = getUsernameField();
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passwordField = getPasswordField();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        getLoginButton().click();
    }
}