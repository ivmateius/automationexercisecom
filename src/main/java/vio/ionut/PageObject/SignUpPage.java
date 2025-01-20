package vio.ionut.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for sign-up page
    private final By signUpHeader = By.cssSelector("div.signup-form>h2");
    private final By userNameField = By.cssSelector("input[data-qa='signup-name']");
    private final By emailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signUpButton = By.cssSelector("button[data-qa='signup-button']");

    // Actions on the sign-up page
    public String getSignUpHeaderText() {
        return driver.findElement(signUpHeader).getText();
    }

    public void enterUserDetails(String userName, String email) {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(emailField).sendKeys(email);
    }

    public AccountCreationPage goToAccountCreationPage() {
        driver.findElement(signUpButton).click();
        return new AccountCreationPage(driver); // Returning the next page object
    }
}
