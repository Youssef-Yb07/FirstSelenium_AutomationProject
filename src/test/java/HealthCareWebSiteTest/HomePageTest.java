package HealthCareWebSiteTest;

import org.example.HealthCareWebSite.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {

    private WebDriver driver;

    private HomePage homePage;

    private WebDriverWait wait;

    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        homePage=new HomePage(driver);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test(description = "Make Appointment Test")
    public void TestMakeAppointment(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getMakeAppointmentButtonLocator()));

        homePage.clickMakeAppointmentButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://katalon-demo-cura.herokuapp.com/profile.php#login"),"Error when redirecting to the login page after clicking into the Make Appointement button");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
