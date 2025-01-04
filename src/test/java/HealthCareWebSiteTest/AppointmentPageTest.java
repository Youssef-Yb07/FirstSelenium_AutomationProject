package HealthCareWebSiteTest;

import org.example.HealthCareWebSite.Pages.AppointmentPage;
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

public class AppointmentPageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "Test Make Appointment when Health Care program is Medicare")
    public void TestMakeAppointmentMedicare() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getMakeAppointmentButtonLocator()));
        homePage.clickMakeAppointmentButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginToBeCopiedLocator()));
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLoginBtn();
        wait.until(ExpectedConditions.visibilityOf(appointmentPage.getSelectLocator()));
        appointmentPage.getSelectLocator().click();
        appointmentPage.SelectElementByValue("Hongkong CURA Healthcare Center");
        appointmentPage.ClickCheckBox();
        boolean isCheckboxSelected = appointmentPage.getCheckBoxLocator().isSelected();
        Assert.assertTrue(isCheckboxSelected,"CheckBox is not selected after clicking");
        appointmentPage.ClickMedicareRadioButton();
        Assert.assertTrue(appointmentPage.IsMedicareRadioButtonSelected(),"Medicare Radio Button is not selected after clicking");
        appointmentPage.ClickDatePicker();
        appointmentPage.ClickDateToSelect();
        Assert.assertEquals(appointmentPage.GetDateSelectedValue(),"13/01/2025","Date is not selected correctly");
        appointmentPage.EnterComment("Test Comment");
        appointmentPage.ClickBookAppointmentButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://katalon-demo-cura.herokuapp.com/appointment.php#summary"),"Appointment is not booked successfully");
        wait.until(ExpectedConditions.visibilityOf(appointmentPage.getFacilityLocator()));
        Assert.assertEquals(appointmentPage.getFacilityLocator().getText(),"Hongkong CURA Healthcare Center","Facility is not selected correctly");
        Assert.assertEquals(isCheckboxSelected,appointmentPage.hospitalReadmission(),"Hospital Readmission is not selected correctly");
        Assert.assertEquals("Medicare",appointmentPage.getProgramText(),"Program is not selected correctly");
        Assert.assertEquals("13/01/2025",appointmentPage.getVisitDateText(),"Date is not selected correctly");
        Assert.assertTrue(appointmentPage.getCommentLocator().getText().contains(appointmentPage.getCommentText()),"Comment is not entered correctly");
        appointmentPage.ClickMenuToggle();
        appointmentPage.ClickLogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://katalon-demo-cura.herokuapp.com/"),"Error when redirecting to the home page after clicking into the Logout button");
    }

  @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
