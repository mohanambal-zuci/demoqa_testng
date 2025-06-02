package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import testbase.TestBase;

import java.time.Duration;

@Epic("Demo QA Login Tests")
@Feature("Login Functionality")
@Listeners({ AllureTestNg.class })
public class LoginTest extends TestBase {

    @Test(description = "Valid Login Test with correct credentials",priority = 1,dataProvider = "validCredentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid login scenario")
    public void validLogin(String username, String password) {
        driver.get("https://demoqa.com/login");
        LoginPage login = new LoginPage(driver);
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/profile", "Login failed or redirect did not happen");
    }

    @Test(description = "Invalid Login Test with wrong credentials", priority = 2,dataProvider = "invalidCredentials")
    @Severity(SeverityLevel.NORMAL)
    @Story("Invalid login scenario")
    public void invalidLogin(String username, String password) {
        driver.get("https://demoqa.com/login");
        LoginPage login = new LoginPage(driver);
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        String errorMsg = login.errorMessage();
        Assert.assertTrue(errorMsg.contains("Invalid username or password!"));
    }
    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][] {
                {"john", "John@123"},
                {"admin", "Admin@123"}
        };
    }
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
                {"john", "wrongPass"},
                {"wrongUser", "John@123"},
        };
    }
}
