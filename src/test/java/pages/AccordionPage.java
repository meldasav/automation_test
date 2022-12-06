package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccordionPage {

    public AccordionPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='accordion']/div[1]")
    public WebElement accordion1;

    @FindBy(xpath = "//div[@class='accordion']/div[3]")
    public WebElement accordion2;

    @FindBy(xpath = "//div[@class='accordion']/div[5]")
    public WebElement accordion3;
}
