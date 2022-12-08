package scripts;

import org.testng.annotations.Test;
import utilities.Waiter;

public class TravelTest extends Base{
    @Test
    public void testTravelPage(){
        driver.get("https://www.easyjet.com/en");
        Waiter.waitUntilTitleIs(driver,8,"easyJet | Cheap flights ✈️ Book low-cost flight tickets 2023");
        System.out.println(driver.getTitle());
        travelHomePage.cookiePanel.click();
        travelHomePage.inputBoxes.get(0).clear();
        travelHomePage.inputBoxes.get(0).sendKeys("London");
        travelHomePage.clickDropDow("London Southend (SEN)United Kingdom");
        }
    }

