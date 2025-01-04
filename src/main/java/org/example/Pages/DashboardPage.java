package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Orange HRM PROJECT

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

    @FindBy(xpath="//input[@placeholder='Search']")
    private WebElement search;

    @FindBy(xpath = "//a[@class='oxd-main-menu-item']")
    private WebElement searchedItem;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-wrapper')]")
    private WebElement Roledropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
    private WebElement adminOption;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchRoleButton;


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

    public WebElement getSearchLocator(){
        return search;
    }

    public void searchItem(String searchKey){
        search.sendKeys(searchKey);
    }

    public void clickSearchedItem(){
        searchedItem.click();
    }


    public WebElement getRoleDropdown(){
        return Roledropdown;
    }

    public void clickRoleDropdown(){
        Roledropdown.click();
    }

    public WebElement getAdminRole(){
        return adminOption;
    }

    public void selectAdminRole(){
        adminOption.click();
    }

    public void clickSearchRoleButton(){
        searchRoleButton.click();
    }

}
