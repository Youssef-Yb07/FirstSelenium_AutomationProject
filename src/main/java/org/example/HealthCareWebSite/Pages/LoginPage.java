package org.example.HealthCareWebSite.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@value='John Doe']")
    private WebElement LoginToBeCopied;

    @FindBy(xpath = "//input[@value='ThisIsNotAPassword']")
    private WebElement PasswordToBeCopied;

    @FindBy(xpath = "//input[@id='txt-username']")
    private WebElement UserName;

    @FindBy(xpath = "//input[@id='txt-password']")
    private WebElement pswd;

    @FindBy(xpath = "//button[@id='btn-login']")
    private WebElement loginBtn;

    @FindBy(css = ".lead.text-danger")
    private WebElement ErrorMessage;

    public WebElement getLoginToBeCopiedLocator(){
        return LoginToBeCopied;
    }

    public void EnterUserName(){
        // copy text from LoginToBeCopied then paste to UserName
        LoginToBeCopied.sendKeys(Keys.CONTROL, "a");
        LoginToBeCopied.sendKeys(Keys.CONTROL, "c");

        // paste to UserName
        UserName.sendKeys(Keys.CONTROL, "v");
    }

    public void EnterPassword(){
        PasswordToBeCopied.sendKeys(Keys.CONTROL,"a");
        PasswordToBeCopied.sendKeys(Keys.CONTROL,"c");
        pswd.sendKeys(Keys.CONTROL, "v");
    }

    public void ClickLoginBtn(){
        loginBtn.click();
    }

    public void EnterInvalidUserName(String usrname){
        UserName.sendKeys(usrname);
    }

    public void EnterInvalidPassword(String passwd){
        pswd.sendKeys(passwd);
    }

    public WebElement getErrorMessageLocator(){
        return ErrorMessage;
    }

    public String getErrorMessage(){
        return ErrorMessage.getText();
    }
}
