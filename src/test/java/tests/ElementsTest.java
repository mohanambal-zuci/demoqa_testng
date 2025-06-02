package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.getDynamicButton()));

        Assert.assertTrue(elementsPage.getDynamicButton().isEnabled(), "Dynamic button should be enabled after delay.");
        elementsPage.clickButton();
    }
}
