package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;

public class Base {

    WebDriver driver;
    HomePage homePage;
    ContactUsPage contactUsPage;

    ThankYouPage thankYouPage;

    RadioButtonPages radioButtonPages;

    ButtonPage buttonPage;

    TestStorePage testStorePage;

    FirstProductPage firstProductPage;

    AccordionPage accordionPage;

    HiddenElementsPage hiddenElementsPage;

    IframePage iframePage;

    TravelHomePage travelHomePage;
    AlertPage alertPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        homePage = new HomePage();
        contactUsPage = new ContactUsPage();
        thankYouPage = new ThankYouPage();
        radioButtonPages = new RadioButtonPages();
        buttonPage = new ButtonPage();
        alertPage = new AlertPage();
        testStorePage = new TestStorePage();
        firstProductPage = new FirstProductPage();
        accordionPage = new AccordionPage();
        hiddenElementsPage = new HiddenElementsPage();
        travelHomePage =new TravelHomePage();
        iframePage = new IframePage();
    }

    @AfterMethod

    public void teardown() {
        softAssert.assertAll();
        Driver.quitDriver();
    }
}