package Assessment_Scenarios;

import Assessment_Scenarios_Locators.Dashboard_Locators;
import Assessment_Scenarios_Locators.LoginPage_Locators;
import Assessment_Scenarios_Locators.MyAccount_Locators;
import Assessment_Scenarios_Locators.TransferMoney_Locators;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class transferMoneyCases {
    WebDriver driver;

    LoginPage_Locators loginActions, homePage;
    Dashboard_Locators dashboardActions;
    MyAccount_Locators myAccountActions;
    TransferMoney_Locators transferMoneyActions;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new LoginPage_Locators(driver);
        homePage.goTo();  // Navigate to the login page
        loginActions = new LoginPage_Locators(driver);
        dashboardActions = new Dashboard_Locators(driver);
        myAccountActions = new MyAccount_Locators(driver);
        transferMoneyActions = new TransferMoney_Locators(driver);

        // Perform login actions using valid credentials
        loginActions.enterUsername("fatih.bolukbas");
        loginActions.enterPassword("159753fatih");
        loginActions.clickLoginButton();

        // Add a delay to wait for the dashboard to load
        Thread.sleep(1000);

        // Navigate to the Money Transfer page
        dashboardActions.clickMoneyTransferButton();
        Thread.sleep(1000);

        myAccountActions.clickTransferMoneyButton();
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void closeButtonTest() {
        WebElement closeButton = transferMoneyActions.getCloseButton();
        Assert.assertTrue(closeButton.isDisplayed(), "Close button is not displayed");
        Assert.assertTrue(closeButton.isEnabled(), "Close button is not enabled");
    }

    @Test(priority = 2)
    public void senderAccountTest() {
        WebElement senderAccount = transferMoneyActions.getSenderAccount();
        Assert.assertTrue(senderAccount.isDisplayed(), "Sender account is not displayed");
        Assert.assertTrue(senderAccount.isEnabled(), "Sender account is not enabled");
        String displayedSenderAccountName = senderAccount.getText();
        Assert.assertEquals(displayedSenderAccountName, "Fatih", "Sender account name is not correct");
    }

    @Test(priority = 3)
    public void receiverAccountTest() {
        WebElement receiverAccountDropdown = transferMoneyActions.getReceiverAccountDropdown();
        Assert.assertTrue(receiverAccountDropdown.isDisplayed(), "Receiver account is not displayed");
        Assert.assertTrue(receiverAccountDropdown.isEnabled(), "Receiver account is not enabled");

        Select dropdown = new Select(receiverAccountDropdown);
        List<String> actualOptions = dropdown.getOptions().stream()
                                    .map(WebElement::getText)
                                    .collect(Collectors.toList());
        List<String> expectedOptions = List.of("Testinium-1", "Testinium-2", "Testinium-3","Testinium-4","Testinium-5");
        for (String option : expectedOptions) {
            Assert.assertTrue(actualOptions.contains(option));
        }
    }

    @Test(priority = 4)
    public void amountTest() {
        WebElement amount = transferMoneyActions.getAmount();
        WebElement myAccountAmount = myAccountActions.getAmount();
        Assert.assertTrue(amount.isDisplayed(), "Amount is not displayed");
        Assert.assertTrue(amount.isEnabled(), "Amount is not enabled");
        transferMoneyActions.enterAmount("900");
        /*String enteredAmount = transferMoneyActions.getEnteredAmount();
        String displayedAmount = myAccountAmount.getText();
        Assert.assertTrue(Integer.parseInt(enteredAmount) <= Integer.parseInt(displayedAmount), "The amount to be transferred exceeds the account balance.");
    */}


}
