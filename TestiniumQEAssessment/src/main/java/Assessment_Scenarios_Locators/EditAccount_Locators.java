package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccount_Locators {
    WebDriver driver; // WebDriver instance to interact with the browser

    // Constructor to initialize WebDriver
    public EditAccount_Locators(WebDriver driver) {
        this.driver=driver;
    }

    // Close button locator
    By closeButton = By.xpath("//div[@class='css-146c3p1 r-lrvibr r-1loqt21']");
    public WebElement getCloseButton(){
        return driver.findElement(closeButton);
    }

    // Page name locator
    By pageName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    public WebElement getPageName(){
        return driver.findElement(pageName);
    }

    // Account name label locator
    By accountNameLabel = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Account name']");
    public WebElement getAccountNameLabel(){
        return driver.findElement(accountNameLabel);
    }

    // Account name locator
    By accountName = By.xpath("//input[@autocapitalize='sentences']");
    public WebElement getAccountName(){
        return driver.findElement(accountName);
    }

    // Update locator
    By updateButton = By.xpath("(//div[@class='css-146c3p1 r-jwli3a r-1b43r93'])[5]");
    public WebElement getUpdateButton(){
        return driver.findElement(updateButton);
    }

    // Method to enter account name
    public void updateAccountName(String newName){
        WebElement newAccountName = getAccountName();
        newAccountName.sendKeys(newName);
    }
}
