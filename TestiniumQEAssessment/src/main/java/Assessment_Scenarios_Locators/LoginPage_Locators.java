package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Locators {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Constructor that initializes the WebDriver
    public LoginPage_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the username input field
    By usernameField = By.xpath("//input[@placeholder='Username']");
    // Method to get the username input field element
    public WebElement getUsernameField() {
        return driver.findElement(usernameField); // Find and return the username input field element
    }

    // Locator for the password input field
    By passwordField = By.xpath("//input[@placeholder='Password']");
    // Method to get the password input field element
    public WebElement getPasswordField() {
        return driver.findElement(passwordField); // Find and return the password input field element
    }

    // Locator for the login button
    By loginButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");
    // Method to get the login button element
    public WebElement getLoginButton() {
        return driver.findElement(loginButton); // Find and return the login button element
    }

    // Method to navigate to the login page (opens the URL)
    public void goTo() {
        driver.get("https://catchylabs-webclient.testinium.com/signIn"); // Navigate to the sign-in page
    }

    // Method to enter the username into the username field
    public void enterUsername(String username) {
        WebElement usernameField = getUsernameField(); // Get the username field element
        usernameField.clear(); // Clear any pre-existing text in the username field
        usernameField.sendKeys(username); // Enter the provided username into the username field
    }

    // Method to enter the password into the password field
    public void enterPassword(String password) {
        WebElement passwordField = getPasswordField(); // Get the password field element
        passwordField.clear(); // Clear any pre-existing text in the password field
        passwordField.sendKeys(password); // Enter the provided password into the password field
    }

    // Method to click the login button
    public void clickLoginButton() {
        getLoginButton().click(); // Find the login button and click it
    }
}