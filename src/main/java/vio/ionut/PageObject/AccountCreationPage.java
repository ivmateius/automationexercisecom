package vio.ionut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage {

    private WebDriver driver;

    // Constructor
    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the account creation page
    private By accountInfoHeader = By.cssSelector("div.login-form>h2");

    // Actions that can be performed on the account creation page
    public String getAccountInfoHeaderText() {
        return driver.findElement(accountInfoHeader).getText();
    }
}
