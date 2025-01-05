package org.example.OrangeHRM.Pages;

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

    //Locators
    @FindBy(css = "input[name='username']")
    private WebElement username;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(xpath = "//button")
    private WebElement loginBtn;

    //Action methods

    public WebElement getUsernameLocator(){
        return username;
    }

    public void enterUsername(String usrname){
        username.sendKeys(usrname);
    }

    public void setPassword(String pswd){
        password.sendKeys(pswd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }





}
