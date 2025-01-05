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

public class DashboardPageTest {

    private WebDriver driver;

    private WebDriverWait wait;

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @Test(description = "", priority = 1)
    public void filterUsersByRoleTest(){
        //Step 1 : Login successfully
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserName()));
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardHeaderElement()));
        Assert.assertTrue(dashboardPage.getDashboardHeader().contains("Dashboard"), "Test Failed: User is not able to login with valid credentials");


        //Step 2 : Search for Admin Page
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getSearchLocator()));
        dashboardPage.searchItem("Admin");

        //Step 3 : Click on admin page
        dashboardPage.clickSearchedItem();

        //Step 4 : wait until role dropdown is visible and click on it
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getRoleDropdown()));
        dashboardPage.clickRoleDropdown();

        //Step 5 : Select Admin from the dropdown
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getAdminRole()));
        dashboardPage.selectAdminRole();

        //Step 6 : Click on search button
        dashboardPage.clickSearchRoleButton();

    }

    //After the executing all test the teardown method is executed
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
