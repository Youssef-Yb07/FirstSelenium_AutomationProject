package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Orange HRM PROJECT

public class LoginPage {

    //We will use POM design pattern
    //POM(page objet model) is a design pattern used in selenium were each web page is represented as a class
    //the purpose of the pom is to separate the web page specific code from the test code
    //each class will contain the web elements and the methods to interact with the web elements
    //and the test code will be in a separate class (in the package test/java)

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement UserName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement Loginboutton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setUserName(String username){
        UserName.sendKeys(username);
    }

    public void setPassword(String pswd){
        password.sendKeys(pswd);
    }

    public void clickLoginBtn(){
        Loginboutton.click();
    }

    public WebElement getErrorMessage(){
        return errorMessage;
    }

    public WebElement getUserName() {
        return UserName;
    }

}
