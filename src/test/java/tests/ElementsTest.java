package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.ElementsPage;
import testbase.TestBase;

import java.time.Duration;

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
