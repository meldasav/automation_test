package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestStorePage {

    public TestStorePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "img[alt='Hummingbird printed t-shirt']")
    public WebElement firstProduct;

    @FindBy(css = "div[class='user-info']>a")
    public WebElement signInButton;

    @FindBy(css ="section input[name='email']")
    public WebElement emailInputBox;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInputBox;

    @FindBy(id = "submit-login")
    public WebElement signInBtn;
}
