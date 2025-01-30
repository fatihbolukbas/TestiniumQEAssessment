package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferMoney_Locators {
    WebDriver driver;
    public TransferMoney_Locators(WebDriver driver) {
        this.driver = driver;
    }

    By closeButton = By.xpath("//div[@class='css-146c3p1 r-lrvibr r-1loqt21']");
    public WebElement getCloseButton() {
        return driver.findElement(closeButton);
    }

    By senderAccount = By.xpath("//div[3]/select");
    public WebElement getSenderAccount() {
        return driver.findElement(senderAccount);
    }

    By receiverAccount = By.xpath("//div[7]/select");
    public WebElement getReceiverAccount() {
        return driver.findElement(receiverAccount);
    }

    By amount = By.xpath("//div[@class='css-175oi2r r-13qz1uu']");
    public WebElement getAmount() {
        return driver.findElement(amount);
    }

    By sendButton = By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1awozwy r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu r-q0mhf2 r-12vffkv']");
    public WebElement getSendButton() {
        return driver.findElement(sendButton);
    }
}
