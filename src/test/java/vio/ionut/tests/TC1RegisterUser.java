package vio.ionut.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vio.ionut.pageobject.HomePage;
import vio.ionut.pageobject.SignUpPage;
import vio.ionut.pageobject.AccountCreationPage;

public class TC1RegisterUser extends BaseTest {

    private HomePage homePage;
    private SignUpPage signUpPage;
    private AccountCreationPage accountCreationPage;

    @Test
    public void registerUser() {
        String userName = "VioTest";
        String emailRegister = "vio@vio.vio";

        // Step 1: Open the homepage
        driver.get("https://www.automationexercise.com/");

        // Initialize HomePage object
        homePage = new HomePage(driver);

        // Step 2: Accept consent pop-up
        homePage.acceptConsentPopUp();

        // Step 3: Navigate to sign-up page
        signUpPage = homePage.goToSignUpPage();

        // Step 4: Enter user details
        signUpPage.enterUserDetails(userName, emailRegister);

        // Step 5: Verify sign-up header text
        Assert.assertEquals(signUpPage.getSignUpHeaderText(), "New User Signup!", "Text not matching!");

        // Step 6: Go to account creation page
        accountCreationPage = signUpPage.goToAccountCreationPage();

        // Step 7: Verify account creation header text
        Assert.assertEquals(accountCreationPage.getAccountInfoHeaderText(), "ENTER ACCOUNT INFORMATION", "Text not matching!");
    }
}
