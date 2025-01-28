package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount_Locators {
    WebDriver driver;
    public MyAccount_Locators(WebDriver driver) {
        this.driver = driver;
    }

    By backButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-vw2c0b r-13hce6t']");
    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    By accountName = By.xpath("//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'][1]");
    public WebElement getAccountName() {
        return driver.findElement(accountName);
    }

    By accountType = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[2]");
    public WebElement getAccountType() {
        return driver.findElement(accountType);
    }

    By accountCreationTime = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[3]");
    public WebElement getAccountCreationTime() {
        return driver.findElement(accountCreationTime);
    }

    By amount = By.xpath("(//div[@class='css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93'])[4]");
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    By transferMoneyButton = By.xpath("(//div[@tabindex='0'])[3]");
    public WebElement getTransferMoneyButton() {
        return driver.findElement(transferMoneyButton);
    }

    By addMoneyButton = By.xpath("//div[contains(text(),'Add money')]");
    public WebElement getAddMoneyButton() {
        return driver.findElement(addMoneyButton);
    }

    By editAccountButton = By.xpath("//div[contains(text(),'Edit account')]");
    public WebElement getEditAccountButton() {
        return driver.findElement(editAccountButton);
    }
}
