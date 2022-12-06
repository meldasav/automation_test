package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHandler;
import utilities.DropDownHandler;
import utilities.Waiter;

import java.util.Iterator;
import java.util.Set;

public class Car extends Base {

    @Test
    public void practice() {
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.loader.click();
        driver.navigate().back();
        homePage.button.click();
        homePage.buttonThreeButton.click();
        AlertHandler.acceptAlert(driver);
        driver.navigate().back();
        homePage.contactUsFormTest.click();
        contactUsPage.firstNameInputBox.sendKeys("Michael");
        contactUsPage.lastNameInputBox.sendKeys("Page");
        contactUsPage.emailInputBox.sendKeys("MichaelPage@gmail.com");
        contactUsPage.textInputBox.sendKeys("urgent");
        contactUsPage.submitButton.click();

        Assert.assertEquals("Thank you for your mail!", thankYouPage.thankYouText.getText());
        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.dropdownCheckBoxRadioButton.click();

        Assert.assertTrue(radioButtonPages.checkBox.isSelected());
        Assert.assertFalse(radioButtonPages.greenCheckBox.isSelected());

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.buttonButton.click();

        Assert.assertFalse(buttonPage.disabledButton.isEnabled());
        Assert.assertTrue(buttonPage.actionMoveButton.isEnabled());

        homePage.dropdownCheckBoxRadioButton.click();
        radioButtonPages.dropdown.click();
        DropDownHandler.selectOptionByValue(radioButtonPages.dropdown, "jeep");

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.alertButton.click();
        alertPage.triggerPopUpBox.click();
        AlertHandler.acceptAlert(driver);

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.dropdownCheckBoxRadioButton.click();
        radioButtonPages.radioButton1.click();
        radioButtonPages.radioButton2.click();
        radioButtonPages.radioButton3.click();

        Assert.assertEquals(driver.getTitle(), "Dropdown Menus");

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.testSore.click();
        testStorePage.firstProduct.click();
        firstProductPage.addToCardButton.click();
        Waiter.pause(5);

        Assert.assertEquals(firstProductPage.price.getText(), "$26.12");
        Assert.assertTrue(Integer.parseInt(firstProductPage.price.getText().substring(1).replace(".", "")) > 0);

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.alertButton.click();
        alertPage.popup.click();

        String mainWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();

        for (String window : handles) {
            if (!window.equals(mainWindow)) driver.switchTo().window(window);
        }
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationtesting.co.uk/popups.html");


//        Iterator<String> iterator = handles.iterator();
//
//        while(iterator.hasNext()){
//            String child = iterator.next();
//
//            if(!mainWindow.equals(child)){
//                driver.switchTo().window(child);
//                driver.close();
//            }
//        }
//        driver.switchTo().window(mainWindow);
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationtesting.co.uk/popups.html");

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.accordion.click();

        for (int i = 0; i <= 6; i++) {
            accordionPage.accordion1.click();
            accordionPage.accordion2.click();
            accordionPage.accordion3.click();
        }

        driver.navigate().to("https://www.automationtesting.co.uk/index.html");
        homePage.hiddenElement.click();
        Assert.assertFalse(hiddenElementsPage.hiddenP.isDisplayed());
        Assert.assertTrue(hiddenElementsPage.visibleText.isDisplayed());
    }
}