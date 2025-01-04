package org.example.HealthCareWebSite.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

    //Declare the WebDriver and the constructor to initialize the PageFactory
    //The PageFactory class is an extension of the Page Object design pattern.
    //It is used to initialize the elements of the Page Object or instantiate the Page Objects itself.
    //It's used in combination with the @FindBy annotation to find and initialize the elements when a page object is created.
    //It's used often with pom (page object model) to create a page object.

    private WebDriver driver;

    public AppointmentPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Declare the WebElements
    //The @FindBy annotation is used in Page Object Model to identify the web elements in the web page.
    //It is used to locate the web elements using locators like id, name, className, xpath, etc.

    @FindBy(css = "#combo_facility")
    private WebElement SelectLocator;

    private Select selectElement;

    @FindBy(xpath = "//*[@id='chk_hospotal_readmission']")
    private WebElement CheckBox;

    @FindBy(xpath = "//input[@id=\"radio_program_medicare\"]")
    private WebElement MedicareRadioButton;

    @FindBy(xpath = "//input[@id=\"radio_program_medicaid\"]")
    private WebElement MedicaidRadioButton;

    @FindBy(xpath = "//input[@id=\"radio_program_none\"]")
    private WebElement NoneRadioButton;

    @FindBy(xpath = "//input[@id=\"txt_visit_date\"]")
    private WebElement DatePicker;

    @FindBy(xpath = "/html/body/div/div[1]/table/tbody/tr[3]/td[2]")
    private WebElement DateToSelect;

    @FindBy(xpath ="//*[@id='txt_comment']")
    private WebElement CommentBox;

    @FindBy(xpath = "//button[@id=\"btn-book-appointment\"]")
    private WebElement BookAppointmentButton;


    //Appointments Results Page Elements

    @FindBy(xpath = "//p[@id=\"facility\"]")
    private WebElement Facility;

    @FindBy(xpath = "//p[@id=\"hospital_readmission\"]")
    private WebElement HospitalReadmission;

    @FindBy(xpath = "//p[@id=\"program\"]")
    private WebElement Program;

    @FindBy(xpath = "//p[@id=\"visit_date\"]")
    private WebElement VisitDate;

    @FindBy(xpath = "//p[@id=\"comment\"]")
    private WebElement Comment;

    @FindBy(xpath = "//a[@id=\"menu-toggle\"]")
    private WebElement MenuToggle;

    @FindBy(xpath = "//a[normalize-space()=\"Logout\"]")
    private WebElement LogoutButton;

    //Methods are used to interact with the elements in the web page.
    //The actions like click, sendKeys, getText, etc. are performed using these methods.

    public WebElement getSelectLocator() {
        return SelectLocator;
    }

    public void SelectElementByIndex(int index) {
        selectElement = new Select(SelectLocator);
        selectElement.selectByIndex(index);
    }

    public void SelectElementByValue(String value) {
        selectElement = new Select(SelectLocator);
        selectElement.selectByValue(value);
    }

    public void SelectElementByVisibleText(String text) {
        selectElement = new Select(SelectLocator);
        selectElement.selectByVisibleText(text);
    }

    //Get Options form select && others methods Used
    /*
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        //Get all the options of the dropdown
        List<WebElement> options = select.getOptions();
        // Get the first selected option of the dropdown
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        // Get all the selected option of the dropdown
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

     */


    // isSelected() method returns true if the checkbox is selected and false in either case
    // isDisplayed() method returns true if the checkbox is displayed and false in either case
    // isEnabled() method returns true if the checkbox is enabled and false in either case
    public WebElement getCheckBoxLocator() {
        return CheckBox;
    }

    public void ClickCheckBox() {
        CheckBox.click();
    }

    // isSelected() method returns true if the radio button is selected and false in either case
    // isDisplayed() method returns true if the radio button is displayed and false in either case
    // isEnabled() method returns true if the radio button is enabled and false in either case
    public void ClickMedicareRadioButton() {
        MedicareRadioButton.click();
    }

    public void ClickMedicaidRadioButton() {
        MedicaidRadioButton.click();
    }

    public void ClickNoneRadioButton() {
        NoneRadioButton.click();
    }

    public boolean IsMedicareRadioButtonSelected() {
        return MedicareRadioButton.isSelected();
    }

    public boolean IsMedicaidRadioButtonSelected() {
        return MedicaidRadioButton.isSelected();
    }

    public boolean IsNoneRadioButtonSelected() {
        return NoneRadioButton.isSelected();
    }

    public void ClickDatePicker() {
        DatePicker.click();
    }

    public void ClickDateToSelect() {
        DateToSelect.click();
    }

    public String GetDateSelectedValue() {
        return DatePicker.getAttribute("value");
    }

    public void EnterComment(String comment) {
        CommentBox.sendKeys(comment);
    }

    public void ClickBookAppointmentButton() {
        BookAppointmentButton.click();
    }

    public WebElement getFacilityLocator() {
        return Facility;
    }

    public String getFacilityText() {
        return Facility.getText();
    }

    public Boolean hospitalReadmission() {
        if(HospitalReadmission.getText().equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    public String getProgramText() {
        return Program.getText();
    }

    public String getVisitDateText() {
        return VisitDate.getText();
    }

    public WebElement getCommentLocator(){
        return Comment;
    }

    public String getCommentText() {
        return Comment.getText();
    }

    public void ClickMenuToggle() {
        MenuToggle.click();
    }

    public void ClickLogoutButton() {
        LogoutButton.click();
    }


}
