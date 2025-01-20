package vio.ionut.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage {

    private WebDriver driver;

    // Constructor
    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the account creation page
    private final By accountInfoHeader = By.cssSelector("div.login-form>h2");

    // Actions on the account creation page
    public String getAccountInfoHeaderText() {
        return driver.findElement(accountInfoHeader).getText();
    }
}
