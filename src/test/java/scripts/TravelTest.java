package scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Waiter;
@Listeners(scripts._01_ITestListener.class)

public class TravelTest extends Base {
    //enable = false use for skipping the test
    //(enable = false)
    @Test
    public void testTravelPage() {
        driver.get("https://www.easyjet.com/en");
        Waiter.waitUntilTitleIs(driver, 8, "easyJet | Cheap flights ✈️ Book low-cost flight tickets 2023");
        travelHomePage.cookiePanel.click();

        for (int i = 0; i <travelHomePage.inputBoxes.size(); i++) {
            if (travelHomePage.inputBoxes.get(i).toString().charAt(i) ==
                travelHomePage.inputBoxes.get(i).toString().charAt(0)) {
                travelHomePage.inputBoxes.get(i).clear();
                travelHomePage.inputBoxes.get(i).sendKeys("London");
                travelHomePage.clickDropDow("London Southend (SEN)United Kingdom");
            }
            if (travelHomePage.inputBoxes.get(i).toString().charAt(i) ==
                travelHomePage.inputBoxes.get(i).toString().charAt(1)) {
                travelHomePage.inputBoxes.get(i).clear();
                travelHomePage.inputBoxes.get(i).sendKeys("A");
                travelHomePage.clickDropDow("Antalya (AYT)Turkey");
            }
        }
    }
}

