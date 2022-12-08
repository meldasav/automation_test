package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage{

    public IframePage(){
        super();
    }

    @FindBy(css = "iframe[src='index.html']")
    public WebElement iframe1;

    @FindBy(css = ".toggle")
    public WebElement iframeMenuBar;

    @FindBy(css = "button[aria-label='Play']")
    public WebElement video;
}
