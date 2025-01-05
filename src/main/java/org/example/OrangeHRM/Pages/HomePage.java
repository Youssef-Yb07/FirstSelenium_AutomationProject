package org.example.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@alt='client brand banner']")
    private WebElement Logo;

    @FindBy(css = "span[class='oxd-userdropdown-tab']")
    private WebElement DropDownLogout;

    @FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//p[contains(@class, 'orangehrm-login-forgot-header')]")
    private WebElement ForgotPassword;

    public WebElement getLogoLocator(){
        return Logo;
    }

    public Boolean isdisplayedLogo(){
        return Logo.isDisplayed();
    }

    public void clickDropDownLogout(){
        DropDownLogout.click();
    }

    public void clickLogoutBtn(){
        logoutBtn.click();
    }

    public WebElement getForgotPasswordLocator(){
        return ForgotPassword;
    }
}
