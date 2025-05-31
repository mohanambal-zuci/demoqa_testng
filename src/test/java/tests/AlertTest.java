package tests;


import io.qameta.allure.Feature;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import testbase.TestBase;

import java.time.Duration;

@Feature("Alerts Validation")
public class AlertTest extends TestBase {

    @Test(description = "Simple alert Validation")
    public void simpleAlert() {
        driver.get("https://demoqa.com/");
        AlertPage alertPage = new AlertPage(driver);

        alertPage.navigateToAlertSection();
        alertPage.triggerSimpleAlert();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button"); // optional assertion
        alert.accept();
    }

    @Test(description = "Delayed alert Validation")
    public void delayedAlertTest() {
        driver.get("https://demoqa.com/");
        AlertPage alerts = new AlertPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        alerts.navigateToAlertSection();
        alerts.triggerDelayedAlert();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test(description = "Delayed alert Validation")
    public void confirmAlertTest() {
        driver.get("https://demoqa.com/");
        AlertPage alerts = new AlertPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        alerts.navigateToAlertSection();
        alerts.triggerConfirmButton();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
