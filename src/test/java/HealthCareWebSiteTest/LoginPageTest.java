package HealthCareWebSiteTest;

import org.example.HealthCareWebSite.Pages.HomePage;
import org.example.HealthCareWebSite.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;

    private HomePage homePage;

    private LoginPage loginPage;

    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Test Login With Valid Credentials")
    public void ValidLoginTest(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getMakeAppointmentButtonLocator()));
        homePage.clickMakeAppointmentButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginToBeCopiedLocator()));

        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLoginBtn();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://katalon-demo-cura.herokuapp.com/#appointment"),"Error when trying to log in");
    }

    @Test(description = "Test Login With invalid Credentials")
    public void FailLoginTest(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getMakeAppointmentButtonLocator()));
        homePage.clickMakeAppointmentButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginToBeCopiedLocator()));

        loginPage.EnterInvalidUserName("INVALID");
        loginPage.EnterInvalidPassword("INVALID");
        loginPage.ClickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessageLocator()));

        Assert.assertEquals("Login failed! Please ensure the username and password are valid.",loginPage.getErrorMessage(),"To user is able to log in with invalid credentials");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
