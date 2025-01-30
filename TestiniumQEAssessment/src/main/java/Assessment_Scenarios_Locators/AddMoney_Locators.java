package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMoney_Locators {
    WebDriver driver;
    private String enteredAmount;  // Variable to store the entered amount

    // Constructor to initialize WebDriver
    public AddMoney_Locators(WebDriver driver) {
        this.driver = driver;
    }

    // Page name locator
    By pageName = By.xpath("//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    public WebElement getPageName() {
        return driver.findElement(pageName);  // Returns the page name element
    }

    // Close button locator
    By closeButton = By.xpath("//div[@class='css-146c3p1 r-lrvibr r-1loqt21']");
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);  // Returns the close button element
    }

    // Card number label locator
    By cardNumberName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div//div[.='Card number']");
    public WebElement getCardNumberName() {
        return driver.findElement(cardNumberName);  // Returns the card number label
    }

    // Card number input field locator
    By cardNumber = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[2]/input");
    public WebElement getCardNumber() {
        return driver.findElement(cardNumber);  // Returns the card number input field
    }

    // Card number validation message locator
    By cardNumberValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[2]/div[.='Required']");
    public WebElement getCardNumberValidation() {
        return driver.findElement(cardNumberValidation);  // Returns the card number validation message
    }

    // Card holder label locator
    By cardHolderName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/div[.='Card holder']");
    public WebElement getCardHolderName() {
        return driver.findElement(cardHolderName);  // Returns the card holder label
    }

    // Card holder input field locator
    By cardHolder = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/input");
    public WebElement getCardHolder() {
        return driver.findElement(cardHolder);  // Returns the card holder input field
    }

    // Card holder validation message locator
    By cardHolderValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[4]/div[.='Required']");
    public WebElement getCardHolderValidation() {
        return driver.findElement(cardHolderValidation);  // Returns the card holder validation message
    }

    // Expiry date label locator
    By expireDateName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[1]//div[.='Expiry date']");
    public WebElement getExpireDateName() {
        return driver.findElement(expireDateName);  // Returns the expiry date label
    }

    // Expiry date input field locator
    By expireDate = By.xpath("//input[@placeholder='MM/YY']");
    public WebElement getExpireDate() {
        return driver.findElement(expireDate);  // Returns the expiry date input field
    }

    // Expiry date validation message locator
    By expireDateValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[1]//div[.='Required']");
    public WebElement getExpireDateValidation() {
        return driver.findElement(expireDateValidation);  // Returns the expiry date validation message
    }

    // CVV label locator
    By cvvName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]/div/div[.='CVV']");
    public WebElement getCvvName() {
        return driver.findElement(cvvName);  // Returns the CVV label
    }

    // CVV input field locator
    By cvv = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]//input");
    public WebElement getCvv() {
        return driver.findElement(cvv);  // Returns the CVV input field
    }

    // CVV validation message locator
    By cvvValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[6]/div[2]//div[.='Required']");
    public WebElement getCvvValidation() {
        return driver.findElement(cvvValidation);  // Returns the CVV validation message
    }

    // Amount label locator
    By amountName = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/div[.='Amount']");
    public WebElement getAmountName() {
        return driver.findElement(amountName);  // Returns the amount label
    }

    // Amount input field locator
    By amount = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/input");
    public WebElement getAmount() {
        return driver.findElement(amount);  // Returns the amount input field
    }

    // Amount validation message locator
    By amountValidation = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div[@class='css-175oi2r r-13awgt0 r-ipm5af']/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[8]/div[.='Required']");
    public WebElement getAmountValidation() {
        return driver.findElement(amountValidation);  // Returns the amount validation message
    }

    // Add button locator
    By addButton = By.xpath("/html/body/div[4]/div/div[@class='css-175oi2r']/div[@role='dialog']/div/div/div/div[2]/div[2]/div[@class='css-175oi2r']/div[10]/div[.='Add']");
    public WebElement getAddButton() {
        return driver.findElement(addButton);  // Returns the 'Add' button
    }

    // Method to enter the card number
    public void enterCardNumber(String cardNumber) {
        WebElement cardNumberField = getCardNumber();
        cardNumberField.sendKeys(cardNumber);  // Enter the card number into the field
    }

    // Method to enter the card holder's name
    public void enterCardHolder(String cardHolder) {
        WebElement cardHolderField = getCardHolder();
        cardHolderField.sendKeys(cardHolder);  // Enter the card holder's name into the field
    }

    // Method to enter the expiry date
    public void enterExpireDate(String expireDate) {
        WebElement expireDateField = getExpireDate();
        expireDateField.sendKeys(expireDate);  // Enter the expiry date into the field
    }

    // Method to enter the CVV
    public void enterCvv(String cvv) {
        WebElement cvvField = getCvv();
        cvvField.sendKeys(cvv);  // Enter the CVV into the field
    }

    // Method to enter the amount
    public void enterAmount(String amount) {
        WebElement amountField = getAmount();
        amountField.sendKeys(amount);  // Enter the amount into the field
        this.enteredAmount = amount;  // Store the entered amount
    }

    // Method to retrieve the entered amount
    public String getEnteredAmount() {
        return this.enteredAmount;  // Returns the entered amount
    }
}
