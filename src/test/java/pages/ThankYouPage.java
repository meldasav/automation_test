package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ThankYouPage {

    public ThankYouPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "div[class='col-8 col-12-small'] h3")
    public WebElement thankYouText;

}
