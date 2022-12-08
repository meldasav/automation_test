package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "LOADER")
    public WebElement loader;

    @FindBy(css = "a[href='buttons.html']")
    public WebElement button;

    @FindBy(id="btn_three")
    public WebElement buttonThreeButton;

    @FindBy(css = "a[href='contactForm.html']")
    public WebElement contactUsFormTest;

    @FindBy(css = "a[href='dropdown.html']")
    public WebElement dropdownCheckBoxRadioButton;

    @FindBy(css = "a[href='buttons.html']")
    public WebElement buttonButton;

    @FindBy(css = "a[href='popups.html']")
    public WebElement alertButton;

    @FindBy(css = "a[href='http://teststore.automationtesting.co.uk/']")
    public WebElement testSore;

    @FindBy(css = "a[href='accordion.html']")
    public WebElement accordion;

    @FindBy(css = "a[href='hiddenElements.html']")
    public WebElement hiddenElement;

    @FindBy(css = "a[href='iframes.html']")
    public WebElement iFrame;
}
