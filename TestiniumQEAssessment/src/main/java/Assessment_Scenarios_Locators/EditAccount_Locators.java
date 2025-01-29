package Assessment_Scenarios_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccount_Locators {
    WebDriver driver;


    public EditAccount_Locators(WebDriver driver){this.driver=driver;}

    By editAccountButton = By.xpath("//div[contains(text(),'Edit account')]");
    public WebElement getEditAccountButton(){
        return driver.findElement(editAccountButton);
    }

    By closeButton = By.xpath("//div[@class='css-146c3p1 r-lrvibr r-1loqt21']");
    public WebElement getCloseButton(){
        return driver.findElement(closeButton);
    }

    By accountNameField = By.xpath("//div[@class='css-175oi2r r-13qz1uu']");
    public WebElement getAccountNameField(){
        return driver.findElement(accountNameField);
    }

    By updateButton = By.xpath("//div[@xpath='1']");
    public WebElement getUpdateButton(){
        return driver.findElement(updateButton);
    }

    public void clickEditAccountButton(){
        getEditAccountButton().click();
    }

    public void clickUpdateButton(){
        getUpdateButton().click();
    }



}
