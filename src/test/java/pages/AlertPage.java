package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AlertPage {

    public AlertPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "button[onclick='alertTrigger()']")
    public WebElement triggerPopUpBox;

    @FindBy(css = "button[onclick='popup()']")
    public WebElement popup;
}
