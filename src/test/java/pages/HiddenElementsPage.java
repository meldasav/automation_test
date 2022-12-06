package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HiddenElementsPage {

    public HiddenElementsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".col-12.col-12-small > p:nth-of-type(2)")
    public WebElement hiddenP;

    @FindBy(css = ".col-12.col-12-small > p:nth-of-type(3)")
    public WebElement visibleText;
}
