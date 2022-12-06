package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FirstProductPage {

    public FirstProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "button[class='btn btn-primary add-to-cart']")
    public WebElement addToCardButton;

    @FindBy(css = ".product-total > .value")
    public WebElement price;
}
