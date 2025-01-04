package org.example.HealthCareWebSite.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver driver;

    @FindBy(id="btn-make-appointment")
    private WebElement makeAppointmentButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getMakeAppointmentButtonLocator(){
        return makeAppointmentButton;
    }

    public void clickMakeAppointmentButton(){
        makeAppointmentButton.click();
    }
}
