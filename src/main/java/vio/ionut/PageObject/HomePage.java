package vio.ionut.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for homepage elements
    private final By consentPopUp = By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button");
    private final By signUpLink = By.cssSelector("a[href='/login']");

    // Actions on the homepage
    public void acceptConsentPopUp() {
        driver.findElement(consentPopUp).click();
    }

    public SignUpPage goToSignUpPage() {
        driver.findElement(signUpLink).click();
        return new SignUpPage(driver); // Returning the next page object
    }
}
