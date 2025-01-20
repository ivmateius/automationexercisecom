package vio.ionut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private WebDriver driver;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the sign-up page
    private By userNameField = By.cssSelector("input[data-qa='signup-name']");
    private By emailField = By.cssSelector("input[data-qa='signup-email']");
    private By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    private By signUpHeaderText = By.cssSelector("div.signup-form>h2");

    // Actions that can be performed on the sign-up page
    public void enterUserDetails(String userName, String email) {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public String getSignUpHeaderText() {
        return driver.findElement(signUpHeaderText).getText();
    }

    // This returns the next page object (AccountCreationPage) after the user clicks sign-up button
    public AccountCreationPage goToAccountCreationPage() {
        clickSignUpButton();
        return new AccountCreationPage(driver);
    }
}
