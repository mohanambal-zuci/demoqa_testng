package testbase;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

@Listeners({AllureTestNg.class})
public class TestBase {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.get("https://demoqa.com/login");
    }

    @AfterMethod
    public void quitDriver() {
        DriverFactory.quitDriver();
    }
}