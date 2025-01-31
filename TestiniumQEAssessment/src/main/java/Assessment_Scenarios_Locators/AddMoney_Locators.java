package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMoney_Locators {
    WebDriver driver; // WebDriver instance to interact with the browser
    private String enteredAmount;  // Variable to store the entered amount

    // Constructor to initialize WebDriver
    public AddMoney_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Page name locator
    By pageName = By.xpath("//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    public WebElement getPageName() {
        return driver.findElement(pageName);
    }

    // Close button locator
    By closeButton = By.xpath("//div[@class='css-146c3p1 r-lrvibr r-1loqt21']");
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    // Card number label locator
    By cardNumberName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Card number']");
    public WebElement getCardNumberName() {
        return driver.findElement(cardNumberName);
    }

    // Card number input field locator
    By cardNumber = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[2]/input");
    public WebElement getCardNumber() {
        return driver.findElement(cardNumber);
    }

    // Card number validation message locator
    By cardNumberValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[2]/div[.='Required']");
    public WebElement getCardNumberValidation() {
        return driver.findElement(cardNumberValidation);
    }

    // Card holder label locator
    By cardHolderName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/div[.='Card holder']");
    public WebElement getCardHolderName() {
        return driver.findElement(cardHolderName);
    }

    // Card holder input field locator
    By cardHolder = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/input");
    public WebElement getCardHolder() {
        return driver.findElement(cardHolder);
    }

    // Card holder validation message locator
    By cardHolderValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/div[.='Required']");
    public WebElement getCardHolderValidation() {
        return driver.findElement(cardHolderValidation);
    }

    // Expiry date label locator
    By expireDateName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[1]//div[.='Expiry date']");
    public WebElement getExpireDateName() {
        return driver.findElement(expireDateName);
    }

    // Expiry date input field locator
    By expireDate = By.xpath("//input[@placeholder='MM/YY']");
    public WebElement getExpireDate() {
        return driver.findElement(expireDate);
    }

    // Expiry date validation message locator
    By expireDateValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[1]//div[.='Required']");
    public WebElement getExpireDateValidation() {
        return driver.findElement(expireDateValidation);
    }

    // CVV label locator
    By cvvName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]/div/div[.='CVV']");
    public WebElement getCvvName() {
        return driver.findElement(cvvName);
    }

    // CVV input field locator
    By cvv = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]//input");
    public WebElement getCvv() {
        return driver.findElement(cvv);
    }

    // CVV validation message locator
    By cvvValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]//div[.='Required']");
    public WebElement getCvvValidation() {
        return driver.findElement(cvvValidation);
    }

    // Amount label locator
    By amountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/div[.='Amount']");
    public WebElement getAmountName() {
        return driver.findElement(amountName);
    }

    // Amount input field locator
    By amount = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/input");
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    // Amount validation message locator
    By amountValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/div[.='Required']");
    public WebElement getAmountValidation() {
        return driver.findElement(amountValidation);
    }

    // Add button locator
    By addButton = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[10]/div[.='Add']");
    public WebElement getAddButton() {
        return driver.findElement(addButton);
    }

    // Method to enter the card number
    public void enterCardNumber(String cardNumber) {
        WebElement cardNumberField = getCardNumber();
        cardNumberField.sendKeys(cardNumber);
    }

    // Method to enter the card holder's name
    public void enterCardHolder(String cardHolder) {
        WebElement cardHolderField = getCardHolder();
        cardHolderField.sendKeys(cardHolder);
    }

    // Method to enter the expiry date
    public void enterExpireDate(String expireDate) {
        WebElement expireDateField = getExpireDate();
        expireDateField.sendKeys(expireDate);
    }

    // Method to enter the CVV
    public void enterCvv(String cvv) {
        WebElement cvvField = getCvv();
        cvvField.sendKeys(cvv);
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
