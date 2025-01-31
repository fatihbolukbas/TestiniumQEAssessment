package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferMoney_Locators {
    WebDriver driver;
    private String enteredAmount;

    // Constructor to initialize the WebDriver
    public TransferMoney_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the close button (used for closing any overlay or pop-up)
    By closeButton = By.xpath("(//div[@class='css-146c3p1 r-lrvibr r-1loqt21'])");
    /**
     * Method to get the close button element.
     * @return WebElement for the close button
     */
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    By pageName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    public WebElement getPageName() {
        return driver.findElement(pageName);
    }

    By senderAccountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Sender account']");
    public WebElement getSenderAccountName() {
        return driver.findElement(senderAccountName);
    }

    // Locator for the sender account dropdown
    By senderAccount = By.xpath("//div[3]/select");
    /**
     * Method to get the sender account dropdown element.
     * @return WebElement for the sender account dropdown
     */
    public WebElement getSenderAccount() {
        return driver.findElement(senderAccount);
    }

    By receiverAccountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Receiver account']");
    public WebElement getReceiverAccountName() {
        return driver.findElement(receiverAccountName);
    }

    // Locator for the receiver account dropdown
    By receiverAccount = By.xpath("//div[7]/select");
    /**
     * Method to get the receiver account dropdown element.
     * @return WebElement for the receiver account dropdown
     */
    public WebElement getReceiverAccount() {
        return driver.findElement(receiverAccount);
    }

    By amountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Amount']");
    public WebElement getAmountName() {
        return driver.findElement(amountName);
    }

    // Locator for the amount input field
    By amount = By.xpath("//div[@class='css-175oi2r r-13qz1uu']/input");
    /**
     * Method to get the amount input field element.
     * @return WebElement for the amount input field
     */
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    // Locator for the send button
    By sendButton = By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1awozwy r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu r-q0mhf2 r-12vffkv']");
    /**
     * Method to get the send button element.
     * @return WebElement for the send button
     */
    public WebElement getSendButton() {
        return driver.findElement(sendButton);
    }

    /**
     * Method to enter an amount into the amount input field.
     * @param amount The amount to be entered
     */
    public void enterAmount(String amount) {
        WebElement amountField = getAmount();
        amountField.sendKeys(amount); // Enter the provided amount into the field
        this.enteredAmount = amount; // Store the entered amount for later verification
    }

    /**
     * Method to get the amount that was entered into the amount input field.
     * @return The entered amount as a string
     */
    public String getEnteredAmount() {
        return this.enteredAmount;
    }

}
