package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ButtonPage {

    public ButtonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#btn_four")
    public WebElement disabledButton;

    @FindBy(css = "#btn_three")
    public WebElement actionMoveButton;
}
