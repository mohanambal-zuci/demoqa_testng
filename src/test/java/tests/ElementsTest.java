package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import testbase.TestBase;

public class ElementsTest extends TestBase {

    @Test(description = "Dynamic Button Validation")
    public void dynamicButtonValidation() {
        driver.get("https://demoqa.com/");
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navigateToElements();
        elementsPage.clickDynamicProperties();
        elementsPage.clickButton();
    }
}
