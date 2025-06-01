package tests;


import io.qameta.allure.Feature;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertModalPage;
import testbase.TestBase;

import java.time.Duration;

@Feature("Alerts Validation")
public class AlertModalTest extends TestBase {

    @Test(description = "Simple alert Validation")
    public void simpleAlert() {
        driver.get("https://demoqa.com/");
        AlertModalPage alertModalPage = new AlertModalPage(driver);

        alertModalPage.navigateToAlertSection();
        alertModalPage.triggerSimpleAlert();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button"); // optional assertion
        alert.accept();
    }

    @Test(description = "Delayed alert Validation")
    public void delayedAlertTest() {
        driver.get("https://demoqa.com/");
        AlertModalPage alerts = new AlertModalPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        alerts.navigateToAlertSection();
        alerts.triggerDelayedAlert();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test(description = "Confirm alert Validation")
    public void confirmAlertTest() {
        driver.get("https://demoqa.com/");
        AlertModalPage alerts = new AlertModalPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        alerts.navigateToAlertSection();
        alerts.triggerConfirmButton();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test(description ="Small Modal Validation")
    public void smallModal(){
        driver.get("https://demoqa.com/");
        AlertModalPage modals = new AlertModalPage(driver);
        modals.navigateToModalSection();
        modals.triggerDialogModal();
        modals.triggerSmallModal();
        String title = modals.getSmallModalTitle();
        Assert.assertEquals(title, "Small Modal", "Modal title mismatch");
        modals.closeSmallModal();
    }

    @Test(description ="Large Modal Validation")
    public void largeModal(){
        driver.get("https://demoqa.com/");
        AlertModalPage modals = new AlertModalPage(driver);
        modals.navigateToModalSection();
        modals.triggerDialogModal();
        modals.triggerLargeModal();
        String title = modals.getLargeModalTitle();
        Assert.assertEquals(title, "Large Modal", "Modal title mismatch");
        modals.closeLargeModal();
    }

}
