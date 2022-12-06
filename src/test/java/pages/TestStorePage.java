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
}
