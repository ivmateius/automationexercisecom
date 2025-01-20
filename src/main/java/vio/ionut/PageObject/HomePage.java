package vio.ionut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the homepage
    private By consentPopUp = By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button");
    private By signUpLoginButton = By.cssSelector("a[href='/login']");

    // Actions that can be performed on the homepage
    public void acceptConsentPopUp() {
        WebElement consentButton = driver.findElement(consentPopUp);
        consentButton.click();
    }

    public SignUpPage goToSignUpPage() {
        driver.findElement(signUpLoginButton).click();
        return new SignUpPage(driver); // Returning SignUpPage object to perform actions on the SignUp page
    }
}
