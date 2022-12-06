package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Waiter;

public class RadioButtonPages {

    public RadioButtonPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css="input[name='cb_red']")
    public WebElement checkBox;

    @FindBy(css="input[id='cb_green']")
    public WebElement greenCheckBox;

    @FindBy(css = "#cars")
    public WebElement dropdown;

    @FindBy(css = "[for='demo-priority-low']")
    public WebElement radioButton1;

    @FindBy(css = "[for='demo-priority-normal']")
    public WebElement radioButton2;

    @FindBy(css = "[for='demo-priority-high']")
    public WebElement radioButton3;
}
