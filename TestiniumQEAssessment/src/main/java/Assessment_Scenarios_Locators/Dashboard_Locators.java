package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Locators {
    WebDriver driver; // WebDriver instance to interact with the browser

    // Constructor to initialize WebDriver
    public Dashboard_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Challenge name field label locator
    By challengeName = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div/div[1]/div[1]");
    public WebElement getChallengeName() {
        return driver.findElement(challengeName);
    }

    // Start time field label locator
    By startTime = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div/div[1]/div[2]");
    public WebElement getStartTime() {
        return driver.findElement(startTime);
    }

    // End time field label locator
    By endTime = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div/div[1]/div[3]");
    public WebElement getEndTime() {
        return driver.findElement(endTime);
    }

    // Manager name field label locator
    By managerName = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div/div[1]/div[4]");
    public WebElement getManagerName() {
        return driver.findElement(managerName);
    }

    // Company name field label locator
    By companyName = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div/div[1]/div[5]");
    public WebElement getCompanyName() {
        return driver.findElement(companyName);
    }

    // 'OPEN MONEY TRANSFER' button locator
    By moneyTransferButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");
    public WebElement getMoneyTransferButton() {
        return driver.findElement(moneyTransferButton);
    }

    // Method to click the "OPEN MONEY TRANSFER" button
    public void clickMoneyTransferButton() {
        getMoneyTransferButton().click();
    }
}
