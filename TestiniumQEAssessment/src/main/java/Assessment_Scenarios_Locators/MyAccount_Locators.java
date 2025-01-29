package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount_Locators {
    WebDriver driver;

    // Constructor that initializes the WebDriver instance
    public MyAccount_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Back" button on the account page
    By backButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-vw2c0b r-13hce6t']");
    public WebElement getBackButton() {
        // Returns the WebElement representing the "Back" button
        return driver.findElement(backButton);
    }

    // Locator for the account name field
    By accountName = By.xpath("//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'][1]");
    public WebElement getAccountName() {
        // Returns the WebElement representing the account name
        return driver.findElement(accountName);
    }

    // Locator for the account type field
    By accountType = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[2]");
    public WebElement getAccountType() {
        // Returns the WebElement representing the account type
        return driver.findElement(accountType);
    }

    // Locator for the account creation time field
    By accountCreationTime = By.xpath("(//div[@class='css-175oi2r r-13qz1uu'])[3]");
    public WebElement getAccountCreationTime() {
        // Returns the WebElement representing the account creation time
        return driver.findElement(accountCreationTime);
    }

    // Locator for the account balance/amount field
    By amount = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[4]");
    public WebElement getAmount() {
        // Returns the WebElement representing the account balance/amount
        return driver.findElement(amount);
    }

    // Locator for the "Transfer Money" button
    By transferMoneyButton = By.xpath("(//div[@tabindex='0'])[3]");
    public WebElement getTransferMoneyButton() {
        // Returns the WebElement representing the "Transfer Money" button
        return driver.findElement(transferMoneyButton);
    }

    // Locator for the "Add Money" button
    By addMoneyButton = By.xpath("//div[contains(text(),'Add money')]");
    public WebElement getAddMoneyButton() {
        // Returns the WebElement representing the "Add Money" button
        return driver.findElement(addMoneyButton);
    }

    // Locator for the "Edit Account" button
    By editAccountButton = By.xpath("//div[contains(text(),'Edit account')]");
    public WebElement getEditAccountButton() {
        // Returns the WebElement representing the "Edit Account" button
        return driver.findElement(editAccountButton);
    }
}
