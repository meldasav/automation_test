package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TravelHomePage extends BasePage {

    public TravelHomePage() {
        super();
    }

    @FindBy(css = "#ensCloseBanner")
    public WebElement cookiePanel;

    @FindBy(css = "input[class^='ej-inpu']")
    public List<WebElement> inputBoxes;

    @FindBy(css = "ul[class*='ui-autocomplete ui-front ui-menu']>li")
    public List<WebElement> londonDropDown;

    public void clickDropDow(String text) {
        for (WebElement element : londonDropDown) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }
}