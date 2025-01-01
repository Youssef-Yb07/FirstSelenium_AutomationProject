package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    public  DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;

    public String getDashboardHeader(){
        return dashboardHeader.getText();
    }

    public void clickDropdown(){
        userDropdown.click();
    }

    public void clickLogout(){
        logoutLink.click();
    }

    public WebElement getDashboardHeaderElement() {
        return dashboardHeader;
    }


    public WebElement getLogoutLink() {
        return logoutLink;
    }
}
