package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount_Locators {
    WebDriver driver;

    // Constructor to initialize WebDriver
    public MyAccount_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Back button locator
    By backButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-vw2c0b r-13hce6t']");
    public WebElement getBackButton() {
        // Returns the WebElement representing the "Back" button
        return driver.findElement(backButton);
    }

    // Account name field label locator
    By accountNameFieldLabel = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-g6644c r-1b43r93'])[1]");
    public WebElement getAccountNameFieldLabel() {
        return driver.findElement(accountNameFieldLabel);
    }

    // Account name field locator
    By accountName = By.xpath("//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'][1]");
    public WebElement getAccountName() {
        // Returns the WebElement representing the account name
        return driver.findElement(accountName);
    }

    // Account type field label locator
    By accountTypeFieldLabel = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[2]//div[.='Account type']");
    public WebElement getAccountTypeFieldLabel() {
        return driver.findElement(accountTypeFieldLabel);
    }

    // // Account type field locator
    By accountType = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[2]");
    public WebElement getAccountType() {
        // Returns the WebElement representing the account type
        return driver.findElement(accountType);
    }

    // Creation type field label locator
    By creationTimeFieldLabel = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[2]//div[.='Creation time']");
    public WebElement getCreationTimeFieldLabel() {
        return driver.findElement(creationTimeFieldLabel);
    }

    // Creation type field locator
    By accountCreationTime = By.xpath("(//div[@class='css-175oi2r r-13qz1uu'])[3]");
    public WebElement getAccountCreationTime() {
        return driver.findElement(accountCreationTime);
    }

    // Amount field label locator
    By amountFieldLabel = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div[2]//div[.='Amount']");
    public WebElement getAmountFieldLabel() {
        return driver.findElement(amountFieldLabel);
    }

    // // Amount field locator
    By amount = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[4]");
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    // 'TRANSFER MONEY' button locator
    By transferMoneyButton = By.xpath("(//div[@class='css-146c3p1 r-jwli3a r-1b43r93'])[2]");
    public WebElement getTransferMoneyButton() {
        return driver.findElement(transferMoneyButton);
    }

    // 'ADD MONEY' button locator
    By addMoneyButton = By.xpath("//div[contains(text(),'Add money')]");
    public WebElement getAddMoneyButton() {
        return driver.findElement(addMoneyButton);
    }

    // 'EDIT ACCOUNT' button locator
    By editAccountButton = By.xpath("//div[contains(text(),'Edit account')]");
    public WebElement getEditAccountButton() {
        return driver.findElement(editAccountButton);
    }

    // Method to click the 'TRANSFER MONEY'
    public void clickTransferMoneyButton() {
        getTransferMoneyButton().click();
    }
}
