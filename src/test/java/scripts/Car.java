package scripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.AlertHandler;
import utilities.DropDownHandler;
import utilities.Waiter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Listeners(scripts._01_ITestListener.class)
public class Car extends Base {

    @Test(priority = 1)
    public void practice() {
        ExtentManager.log("Test");
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.loader.click();
        driver.navigate().back();
        homePage.button.click();
        homePage.buttonThreeButton.click();
        AlertHandler.acceptAlert(driver);
        driver.navigate().back();
        ExtentManager.pass("Reached the HomePage");
        homePage.contactUsFormTest.click();
        contactUsPage.firstNameInputBox.sendKeys("Michael");
        ExtentManager.pass("FirstName successfully added");
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

    @Test(priority = 2)
    public void testIframe() {
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.iFrame.click();
        driver.switchTo().frame(iframePage.iframe1);
        iframePage.iframeMenuBar.click();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        iframePage.video.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Waiter.pause(19);
    }

    @Test(priority = 3)
    public void testBrowserTab() {
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.browserTab.click();
        for (int i = 0; i < 3; i++) {
            browserTabPage.openTabBox.click();
        }
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String item : windowHandles) {
            driver.switchTo().window(item);
        }
        driver.switchTo().window(windowHandles.get(0));
        browserTabPage.openTabBox.click();

    }

    @Test(priority = 4)
    public void javaExecuter() {
        driver.get("https://www.automationtesting.co.uk/index.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }

    @Test(priority = 5)
    public void javaScript() {
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.contactUsFormTest.click();
        contactUsPage.firstNameInputBox.sendKeys("Michael");
        contactUsPage.lastNameInputBox.sendKeys("Page");
        contactUsPage.emailInputBox.sendKeys("MichaelPage@gmail.com");
        contactUsPage.textInputBox.sendKeys("urgent");

        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        WebElement reset = driver.findElement(By.cssSelector("[type='reset']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click(),arguments[1].click()", reset, submit);

        WebElement errorMessage = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(errorMessage.getText(), "Error: all fields are required\n" +
                "Error: Invalid email address");
    }

    @Test(priority = 6)
    public void chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("https://www.automationtesting.co.uk/index.html");
    }

    @Test(priority = 7)
    public void desireCapabilities() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("https://expired.badssl.com/");
    }


    public static void takescreenShot(WebDriver webDriver) throws IOException {
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("/Users/meldasav/IdeaProjects/Intro/screenshots/" + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    @Test(priority = 8)
    public void screenShot() throws IOException {
        driver.get("https://www.automationtesting.co.uk/index.html");
        homePage.contactUsFormTest.click();
        takescreenShot(driver);
    }

    @Test(priority = 9, groups = "Signln")
    public void signIn() {
        driver.get("http://teststore.automationtesting.co.uk/");
        testStorePage.signInButton.click();
        testStorePage.emailInputBox.sendKeys("melsel@gmail.com");
        testStorePage.passwordInputBox.sendKeys("12345");
        testStorePage.signInBtn.click();
        testStoreContactUsPage.signOutBtn.click();
    }
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"melsel@gmail.com", "12345"}, {"mese@gmail.com", "123456"}};

    }
    @Test(priority = 10, dataProvider = "getData")
    public void testData(String email , String password) {

        driver.get("http://teststore.automationtesting.co.uk/");
        testStorePage.signInButton.click();
        testStorePage.emailInputBox.sendKeys(email);
        testStorePage.passwordInputBox.sendKeys(password);
        testStorePage.signInBtn.click();
        testStoreContactUsPage.signOutBtn.click();
    }

}

