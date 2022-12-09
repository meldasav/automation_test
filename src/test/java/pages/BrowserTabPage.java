package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserTabPage extends BasePage {
    public BrowserTabPage(){
        super();
    }
    @FindBy(css = "input[type='submit']")
    public WebElement openTabBox;
}
