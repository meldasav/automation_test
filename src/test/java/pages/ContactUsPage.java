package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {
    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[name='first_name']")
    public WebElement firstNameInputBox;

    @FindBy(css = "input[name='last_name']")
    public WebElement lastNameInputBox;

    @FindBy(css = "input[name='email']")
    public WebElement emailInputBox;

    @FindBy(css = "textarea[name='message']")
    public WebElement textInputBox;

    @FindBy(css = "input[type='submit']")
    public WebElement submitButton;

}
