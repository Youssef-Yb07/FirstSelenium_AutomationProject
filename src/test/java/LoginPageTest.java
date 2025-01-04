import org.example.Pages.DashboardPage;
import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class LoginPageTest {

    private WebDriver driver;

    private WebDriverWait wait;

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    //BeforeTest is executed before the execution of each test case
    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @Test(description = "Verify login Page with valid credentials and logout from the application" , priority = 1)
    public void testLoginWithValidCredentials() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserName()));
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardHeaderElement()));
        String actual = dashboardPage.getDashboardHeader();
        Assert.assertEquals(actual, "Dashboard", "Test Failed: User is not able to login with valid credentials");

        dashboardPage.clickDropdown();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getLogoutLink()));
        dashboardPage.clickLogout();

        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("auth/login"), "User is not redirected to the login page after logout.");

    }

    @Test(description = "Verify login Page with invalid credentials" ,priority = 2)
    public void testLoginWithInvalidCredentials() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserName()));
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin1234");
        loginPage.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));
        String actual = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actual.contains("Invalid credentials"), "Error message is incorrect or not displayed");
    }


    //After the executing all test the teardown method is executed
    @AfterTest
    public void teardownMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
