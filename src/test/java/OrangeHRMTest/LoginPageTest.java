package OrangeHRMTest;

import org.example.OrangeHRM.Pages.HomePage;
import org.example.OrangeHRM.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @DataProvider(name = "login_credentials")
    Object [][] loginData(){
        Object data [][] ={
                {"user1","pass1"},
                {"user2","pass2"},
                {"user3","pass3"},
                {"Admin","admin123"}
        } ;
        return data;
    }

    @Test(description = "Test login page" , priority = 1 , dataProvider = "login_credentials")
    public void TestLogin(String email,String password) {

        wait.until(ExpectedConditions.visibilityOf(loginPage.getUsernameLocator()));

        loginPage.enterUsername(email);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(homePage.getLogoLocator()));

        Assert.assertTrue(homePage.isdisplayedLogo());
    }

    @Test(description = "logout method" , priority = 2)
    public void logout(){
        homePage.clickDropDownLogout();
        homePage.clickLogoutBtn();
        wait.until(ExpectedConditions.visibilityOf(homePage.getForgotPasswordLocator()));
        Assert.assertTrue(homePage.getForgotPasswordLocator().isDisplayed(),"Error logout");
    }

    @AfterTest
    public void turnDown(){
        driver.quit();
    }
}
