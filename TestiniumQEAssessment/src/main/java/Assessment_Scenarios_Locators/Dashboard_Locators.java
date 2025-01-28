package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Locators {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Constructor that initializes the WebDriver instance for interacting with the dashboard page
    public Dashboard_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Money Transfer" button on the dashboard
    By moneyTransferButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");
    // Method to get the "Money Transfer" button element
    public WebElement getMoneyTransferButton() {
        return driver.findElement(moneyTransferButton); // Find and return the "Money Transfer" button element
    }

    // Method to click the "Money Transfer" button
    public void clickMoneyTransferButton() {
        getMoneyTransferButton().click(); // Find the "Money Transfer" button and click it
    }
}
