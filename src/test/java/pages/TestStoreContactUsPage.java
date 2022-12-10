package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestStoreContactUsPage extends BasePage{

    public TestStoreContactUsPage(){
        super();
    }

    @FindBy(css = "a[class='logout hidden-sm-down']")
    public WebElement signOutBtn;
}
