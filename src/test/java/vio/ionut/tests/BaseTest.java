package vio.ionut.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    // Set up WebDriver
    @BeforeTest
    public void setUp() {
        // Setup WebDriverManager to automatically manage the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver (Chrome in this case)
        driver = new ChromeDriver();
        driver.manage().window().maximize();  // Maximize the browser window
    }

    // Clean up after each test
    @AfterTest
    public void tearDown() {
        // Quit the driver after test completion
        if (driver != null) {
            driver.quit();
        }
    }
}
