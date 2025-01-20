package vio.ionut.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vio.ionut.pages.HomePage;
import vio.ionut.pages.SignUpPage;
import vio.ionut.pages.AccountCreationPage;

public class TC1RegisterUser {

    private WebDriver driver;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private AccountCreationPage accountCreationPage;

    @BeforeTest
    public void setUp() {
        // Setup WebDriverManager to automatically manage the ChromeDriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Page Objects
        homePage = new HomePage(driver);
    }

    @Test
    public void registerUser() {
        String userName = "VioTest";
        String emailRegister = "vio@vio.vio";

        // Step 1: Open the homepage
        driver.get("https://www.automationexercise.com/");

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

    @AfterTest
    public void tearDown() {
        // Quit the driver after test completion
        if (driver != null) {
            driver.quit();
        }
    }
}
