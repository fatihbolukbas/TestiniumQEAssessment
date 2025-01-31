package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferMoney_Locators {
    WebDriver driver; // WebDriver instance to interact with the browser
    private String enteredAmount; // Variable to store the entered amount

    // Constructor to initialize WebDriver
    public TransferMoney_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Close button locator
    By closeButton = By.xpath("(//div[@class='css-146c3p1 r-lrvibr r-1loqt21'])");
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    // Page name locator
    By pageName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    public WebElement getPageName() {
        return driver.findElement(pageName);
    }

    // Sender account name locator
    By senderAccountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Sender account']");
    public WebElement getSenderAccountName() {
        return driver.findElement(senderAccountName);
    }

    // Sender account dropdown locator
    By senderAccount = By.xpath("//div[3]/select");
    public WebElement getSenderAccount() {
        return driver.findElement(senderAccount);
    }

    // Receiver account name locator
    By receiverAccountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Receiver account']");
    public WebElement getReceiverAccountName() {
        return driver.findElement(receiverAccountName);
    }

    // Receiver account dropdown locator
    By receiverAccount = By.xpath("//div[7]/select");
    public WebElement getReceiverAccount() {
        return driver.findElement(receiverAccount);
    }

    // Ammount name locator
    By amountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Amount']");
    public WebElement getAmountName() {
        return driver.findElement(amountName);
    }

    // Amount input field locator
    By amount = By.xpath("//div[@class='css-175oi2r r-13qz1uu']/input");
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    // Send button locator
    By sendButton = By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1awozwy r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu r-q0mhf2 r-12vffkv']");
    public WebElement getSendButton() {
        return driver.findElement(sendButton);
    }

    // Method to enter the amount
    public void enterAmount(String amount) {
        WebElement amountField = getAmount();
        amountField.sendKeys(amount);
        this.enteredAmount = amount;
    }

    // Method to retrieve the entered amount
    public String getEnteredAmount() {
        return this.enteredAmount;
    }

}
